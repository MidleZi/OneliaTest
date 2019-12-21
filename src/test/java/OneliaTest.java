import libs.Init;
import org.junit.Test;
import ru.pages.*;

public class OneliaTest {

    @Test
    public void authorizationTest() throws Exception {
        Init.openStartUpPage("https://ticket.rzd.ru/");
        TicketRZDMainPage mainPage = new TicketRZDMainPage();
        mainPage.userOnPage();
        mainPage.clickButton("Кнопка логина(ключик)");
        mainPage.sendKeys("Поле логин", "kakoito123");
        mainPage.sendKeys("Поле пароль", "123456");
        mainPage.clickButton("Кнопка войти");
        mainPage.userIsAuthorized("Какой-то Какойтович");
        Init.closeWebDriver();

    }

    @Test
    public void buyTicketMoscowToKazan() {
        Init.openStartUpPage("https://ticket.rzd.ru/");
        TicketRZDMainPage mainPage = new TicketRZDMainPage();
        mainPage.autorization("kakoito123", "123456");

        mainPage.sendKeys("Откуда", "Москва");
        mainPage.sendKeys("Куда", "Казань");
        mainPage.sendKeys("Туда", Init.getCurrentDate());
        mainPage.sendKeys("Обратно", Init.getCurrentDate(55));
        mainPage.clickButton("Кнопка найти");


        ChoiseTrainPage trainPage = new ChoiseTrainPage();
        //выбираем первый попавшийся элемент соответсвующий условию поиска
        trainPage.clickButton("Плитка выбора поезда");

        ChoiseTrainServisePage trainServicePage = new ChoiseTrainServisePage();
        trainServicePage.clickButton("Кнопка выбрать");

        ChoiseTrainSeatsPage seatsPage = new ChoiseTrainSeatsPage();

        seatsPage.clickButton("Выбор свободного места");
        seatsPage.clickButton("Кнопка продолжить");

        ChoisePassenegerPage choisePassenger = new ChoisePassenegerPage();

        choisePassenger.clickButton("Вырать пассажира");
        choisePassenger.clickButton("Пассажир");
        choisePassenger.clickButton("К обратной поездке");


        //по хорошему тут можно добавить что-то типа User on page
        //но я пойду простым путем)
        //тут какой-то глюк на странице, толи фокус теряется толи что-то такое, нужно сначала просто кликнуть, после этого страница становится доступной
        trainPage.actionClick();
        trainPage.clickButton("Плитка выбора поезда");

        trainServicePage.clickButton("Кнопка выбрать");

        seatsPage.clickButton("Выбор свободного места");
        seatsPage.clickButton("Кнопка продолжить");

        ConfirmOrderPage confirmPage = new ConfirmOrderPage();

        confirmPage.clickButton("Оформить заказ");

        //дальше меня почему-то не пускает,Ю говорит, что время выполнения операции исеткло

        Init.closeWebDriver();
    }
}
