import libs.Init;
import org.junit.Test;
import ru.pages.TicketRZDMainPage;

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
}
