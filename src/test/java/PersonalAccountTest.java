import io.qameta.allure.Description;
import io.qameta.allure.junit4.DisplayName;
import org.junit.Test;
import stellarburgers.pages_burger.LoginUserPage;
import stellarburgers.pages_burger.MainPageBurger;
import stellarburgers.pages_burger.ProfileUserPage;

import static org.junit.Assert.assertTrue;
import static stellarburgers.pages_burger.BasePage.*;

public class PersonalAccountTest extends BaseWithUserTest {

    @Test
    @DisplayName("Проверка входа в Личный кабинет через главную страницу.")
    @Description("Тест проверяет переход в Личный кабинет по клику по кнопке «Личный кабинет» на главной странице.")
    public void enterInPersonalAccountTest() {
        MainPageBurger mainPage = new MainPageBurger(driver);
        ProfileUserPage profileUserPage = new ProfileUserPage(driver);
        LoginUserPage loginUserPage = new LoginUserPage(driver);

        mainPage.clickLoginButton();
        loginUserPage.setUserForLogin(BaseWithUserTest.user.getEmail(), BaseWithUserTest.user.getPassword());
        loginUserPage.clickLoginButton();

        mainPage.clickPersonalAccountButton();

        assertTrue("Вход в личный кабинет пользователя не произошёл",
                profileUserPage.isProfileButtonDisplayed() && profileUserPage.getUrlPage().equals(URL_PROFILE_USER_PAGE));
    }
    @Test
    @DisplayName("Проверка перехода из Личного кабинета в Конструктор через клик на \"Конструктор\".")
    @Description("Тест проверяет переход из Личного кабинета в Конструктор по клику по кнопке \"Конструктор\" в заголовке.")
    public void goToConstructorPageClickConstructorTest() {
        MainPageBurger mainPage = new MainPageBurger(driver);
        ProfileUserPage profileUserPage = new ProfileUserPage(driver);
        LoginUserPage loginUserPage = new LoginUserPage(driver);

        mainPage.clickLoginButton();
        loginUserPage.setUserForLogin(BaseWithUserTest.user.getEmail(), BaseWithUserTest.user.getPassword());
        loginUserPage.clickLoginButton();

        mainPage.clickPersonalAccountButton();
        profileUserPage.clickConstructorButton();

        assertTrue("Переход в Конструктор (главная страница) не произошёл",
                mainPage.isTitlePageDisplayed() && mainPage.getUrlPage().equals(URL_MAIN_PAGE));
    }
    @Test
    @DisplayName("Проверка перехода из Личного кабинета в Конструктор через клик на логотип.")
    @Description("Тест проверяет переход из Личного кабинета в Конструктор по клику на логотип \"Stellar Burgers\" в заголовке.")
    public void goToConstructorPageClickLogoTest() {
        MainPageBurger mainPage = new MainPageBurger(driver);
        ProfileUserPage profileUserPage = new ProfileUserPage(driver);
        LoginUserPage loginUserPage = new LoginUserPage(driver);

        mainPage.clickLoginButton();
        loginUserPage.setUserForLogin(BaseWithUserTest.user.getEmail(), BaseWithUserTest.user.getPassword());
        loginUserPage.clickLoginButton();

        mainPage.clickPersonalAccountButton();
        profileUserPage.clickLogoButton();

        assertTrue("Переход в Конструктор (главная страница) не произошёл",
                mainPage.isTitlePageDisplayed() && mainPage.getUrlPage().equals(URL_MAIN_PAGE));
    }
    @Test
    @DisplayName("Проверка выхода из аккаунта из Личный кабинет.")
    @Description("Тест проверяет выход из аккаунта по клику по кнопке \"Выйти\" в Личном кабинете.")
    public void logoutPersonalAccountTest() {
        MainPageBurger mainPage = new MainPageBurger(driver);
        ProfileUserPage profileUserPage = new ProfileUserPage(driver);
        LoginUserPage loginUserPage = new LoginUserPage(driver);

        mainPage.clickLoginButton();
        loginUserPage.setUserForLogin(BaseWithUserTest.user.getEmail(), BaseWithUserTest.user.getPassword());
        loginUserPage.clickLoginButton();

        mainPage.clickPersonalAccountButton();
        profileUserPage.clickLogoutButton();

        assertTrue("Выход из Личного кабинета не произошёл",
                loginUserPage.isTitleLoginPageDisplayed() && loginUserPage.getUrlPage().equals(URL_LOGIN_PAGE));
    }
}

