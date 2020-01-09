import libs.Init;
import libs.PageFactory;
import org.junit.Test;
import ru.pages.*;

public class OneliaTest extends Init{

    @Test
    public void authorizationTest() throws Exception {
        Init.openStartUpPage("https://ticket.rzd.ru/");
        TicketRZDMainPage mainPage = (TicketRZDMainPage) Init.getPageFactory().getPage("Главная страница");

        //TicketRZDMainPage mainPage = new TicketRZDMainPage();
        mainPage.userOnPage();
        mainPage.clickButton("Кнопка логина(ключик)");
        mainPage.sendKeys("Поле логин", "kakoito123");
        mainPage.sendKeys("Поле пароль", "123456");
        mainPage.clickButton("Кнопка войти");
        mainPage.userIsAuthorized("Какой-то Какойтович");

    }

    @Test
    public void buyTicketMoscowToKazan() throws Exception {
        Init.openStartUpPage("https://ticket.rzd.ru/");
        TicketRZDMainPage mainPage = (TicketRZDMainPage) Init.getPageFactory().getPage("Главная страница");
        mainPage.autorization("kakoito123", "123456");

        mainPage.sendKeys("Откуда", "Москва");
        mainPage.sendKeys("Куда", "Казань");
        mainPage.sendKeys("Туда", Init.getCurrentDate());
        mainPage.sendKeys("Обратно", Init.getCurrentDate(55));
        mainPage.clickButton("Кнопка найти");


        ChoiseTrainPage trainPage = (ChoiseTrainPage) Init.getPageFactory().getPage("Выбор поезда");
        //выбираем первый попавшийся элемент соответсвующий условию поиска
        trainPage.clickButton("Плитка выбора поезда");

        ChoiseTrainServisePage trainServicePage = (ChoiseTrainServisePage) Init.getPageFactory().getPage("Выбор типа купе");
        trainServicePage.clickButton("Кнопка выбрать");

        ChoiseTrainSeatsPage seatsPage = (ChoiseTrainSeatsPage) Init.getPageFactory().getPage("Выбор места");

        seatsPage.clickButton("Выбор свободного места");
        seatsPage.clickButton("Кнопка продолжить");

        ChoisePassenegerPage choisePassenger = (ChoisePassenegerPage) Init.getPageFactory().getPage("Выбор пассажира");

        choisePassenger.clickButton("Вырать пассажира");
        choisePassenger.clickButton("Пассажир");
        choisePassenger.clickButton("К обратной поездке");


        //по хорошему тут можно добавить что-то типа User on page
        //но я пойду простым путем)
        trainPage.userOnPage();
        //тут какой-то глюк на странице, толи фокус теряется толи что-то такое, нужно сначала просто кликнуть, после этого страница становится доступной
        trainPage.actionClick();
        trainPage.clickButton("Плитка выбора поезда");

        trainServicePage.clickButton("Кнопка выбрать");

        seatsPage.clickButton("Выбор свободного места");
        seatsPage.clickButton("Кнопка продолжить");

        ConfirmOrderPage confirmPage = (ConfirmOrderPage) Init.getPageFactory().getPage("Подтверждение заказа");

        confirmPage.clickButton("Оформить заказ");

        //дальше меня почему-то не пускает, говорит, что время выполнения операции исеткло
    }
}
