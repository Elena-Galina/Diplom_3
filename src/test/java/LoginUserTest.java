import io.qameta.allure.Description;
import io.qameta.allure.Step;
import io.qameta.allure.junit4.DisplayName;
import org.junit.*;
import stellarburgers.pages_burger.LoginUserPage;
import stellarburgers.pages_burger.MainPageBurger;
import stellarburgers.pages_burger.PassRecoveryUserPage;
import stellarburgers.pages_burger.RegisterUserPage;

import static org.junit.Assert.assertTrue;
import static stellarburgers.pages_burger.BasePage.*;

public class LoginUserTest extends BaseWithUserTest {

    @Test
    @DisplayName("Проверка входа по кнопке «Войти в аккаунт» на главной странице.")
    @Description("Тест проверяет вход пользователя по кнопке «Войти в аккаунт» на главной странице.")
    public void loginUserOnMainPageTest() {
        MainPageBurger mainPage = new MainPageBurger(driver);
        LoginUserPage loginUserPage = new LoginUserPage(driver);

        mainPage.clickLoginButton();
        checkGoToLoginPageTest();

        loginUserPage.setUserForLogin(BaseWithUserTest.user.getEmail(), BaseWithUserTest.user.getPassword());
        loginUserPage.clickLoginButton();

        assertTrue("Вход в аккаунт не выполнен. Кнопка \"Оформить заказ\" на главной странице не появилась",
                mainPage.isOrderButtonDisplayed());
    }

    @Test
    @DisplayName("Проверка входа через кнопку «Личный кабинет» на главной странице.")
    @Description("Тест проверяет вход пользователя через кнопку «Личный кабинет» на главной странице.")
    public void loginUserOnPersonalAccountButtonTest() {
        MainPageBurger mainPage = new MainPageBurger(driver);
        LoginUserPage loginUserPage = new LoginUserPage(driver);

        mainPage.clickPersonalAccountButton();
        checkGoToLoginPageTest();

        loginUserPage.setUserForLogin(BaseWithUserTest.user.getEmail(), BaseWithUserTest.user.getPassword());
        loginUserPage.clickLoginButton();

        assertTrue("Вход в аккаунт не выполнен. Кнопка \"Оформить заказ\" на главной странице не появилась",
                mainPage.isOrderButtonDisplayed());
    }

    @Test
    @DisplayName("Проверка входа через кнопку \"Войти\" в форме регистрации.")
    @Description("Тест проверяет вход пользователя через кнопку \"Войти\" в форме регистрации.")
    public void loginUserOnRegisterUserPageTest() {
        MainPageBurger mainPage = new MainPageBurger(driver);
        LoginUserPage loginUserPage = new LoginUserPage(driver);
        RegisterUserPage registerUserPage = new RegisterUserPage(driver);

        mainPage.clickLoginButton();
        loginUserPage.clickRegisterButton();
        registerUserPage.clickLoginButton();
        checkGoToLoginPageTest();

        loginUserPage.setUserForLogin(BaseWithUserTest.user.getEmail(), BaseWithUserTest.user.getPassword());
        loginUserPage.clickLoginButton();

        assertTrue("Вход в аккаунт не выполнен. Кнопка \"Оформить заказ\" на главной странице не появилась",
                mainPage.isOrderButtonDisplayed());
    }

    @Test
    @DisplayName("Проверка входа через кнопку \"Войти\" в форме восстановления пароля.")
    @Description("Тест проверяет вход пользователя через кнопку \"Войти\" в форме восстановления пароля.")
    public void loginUserOnPassRecoveryUserPageTest() {
        MainPageBurger mainPage = new MainPageBurger(driver);
        LoginUserPage loginUserPage = new LoginUserPage(driver);
        PassRecoveryUserPage passRecoveryUserPage = new PassRecoveryUserPage(driver);

        mainPage.clickLoginButton();
        loginUserPage.clickForgotPasswordButton();
        passRecoveryUserPage.clickLoginButton();
        checkGoToLoginPageTest();

        loginUserPage.setUserForLogin(BaseWithUserTest.user.getEmail(), BaseWithUserTest.user.getPassword());
        loginUserPage.clickLoginButton();

        assertTrue("Вход в аккаунт не выполнен. Кнопка \"Оформить заказ\" на главной странице не появилась",
                mainPage.isOrderButtonDisplayed());
    }

    @Step("Проверить переход на страницу авторизации")
    public void checkGoToLoginPageTest() {
        LoginUserPage loginUserPage = new LoginUserPage(driver);
        assertTrue("Переход на страницу авторизации не произошёл",
                loginUserPage.isTitleLoginPageDisplayed()  && loginUserPage.getUrlPage().equals(URL_LOGIN_PAGE));
    }
}
