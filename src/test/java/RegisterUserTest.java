import io.qameta.allure.Description;
import io.qameta.allure.Step;
import io.qameta.allure.junit4.DisplayName;
import org.junit.Test;
import stellarburgers.pages_burger.LoginUserPage;
import stellarburgers.pages_burger.MainPageBurger;
import stellarburgers.pages_burger.RegisterUserPage;

import static org.junit.Assert.assertTrue;
import static stellarburgers.pages_burger.BasePage.URL_REGISTER_PAGE;
import static stellarburgers.user_api.UserGenerator.*;

public class RegisterUserTest extends BaseTest {

    @Test
    @DisplayName("Проверка регистрации пользователя.")
    @Description("Тест проверяет успешную регистрацию пользователя.")
    public void registrationUserTest() {
        MainPageBurger mainPage = new MainPageBurger(driver);
        LoginUserPage loginUserPage = new LoginUserPage(driver);
        RegisterUserPage registerUserPage = new RegisterUserPage(driver);

        mainPage.clickLoginButton();
        loginUserPage.clickRegisterButton();
        checkGoToRegisterPageTest();

        registerUserPage.setUser(randomName(), randomEmail(), randomPassword());
        registerUserPage.clickRegisterButton();

        assertTrue("Регистрация не произошла", loginUserPage.isTitleLoginPageDisplayed());
    }

    @Test
    @DisplayName("Проверка появления ошибки при регистрации пользователя с неверным паролем.")
    @Description("Тест проверяет, что при вводе неверного пароля появляется сообщение об ошибке \"Некорректный пароль\".")
    public void errorForInvalidPasswordTest() {
        MainPageBurger mainPage = new MainPageBurger(driver);
        LoginUserPage loginUserPage = new LoginUserPage(driver);
        RegisterUserPage registerUserPage = new RegisterUserPage(driver);

        mainPage.clickLoginButton();
        loginUserPage.clickRegisterButton();
        checkGoToRegisterPageTest();

        registerUserPage.setUser(randomName(), randomEmail(), randomInvalidPassword());
        registerUserPage.clickRegisterButton();

        assertTrue("Ошибка о вводе некорректного пароля не появилась", registerUserPage.isErrorMessageVisible());
    }

    @Step("Проверить переход на страницу регистрации")
    public void checkGoToRegisterPageTest() {
        RegisterUserPage registerUserPage = new RegisterUserPage(driver);
        assertTrue("Переход на страницу регистрации не произошёл",
                registerUserPage.isTitleLoginPageDisplayed() && registerUserPage.getUrlPage().equals(URL_REGISTER_PAGE));
    }
}
