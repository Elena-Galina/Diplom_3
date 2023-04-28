package stellarburgers.pages_burger;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginUserPage extends BasePage {
    //Заголовок страницы авторизации
    private final By titleLoginPage = By.xpath("//*[text()='Вход']");
    //Поле ввода "Email"
    private final By emailFieldLoginPage = By.xpath("//input[@name='name']");
    //Поле ввода "Пароль"
    private final By passwordFieldLoginPage = By.xpath("//input[@name='Пароль']");
    //Кнопка "Войти"
    private final By loginButtonLoginPage = By.xpath("//button[text()='Войти']");
    //Кнопка "Зарегистироваться"
    private final By registerButtonLoginPage = By.xpath("//a[@href = '/register' and text()='Зарегистрироваться']");
    //Кнопка "Восстановить пароль"
    private final By forgotPasswordButtonLoginPage = By.xpath("//a[@href = '/forgot-password' and text()='Восстановить пароль']");

    public LoginUserPage(WebDriver driver) {
        super(driver);
    }

    @Step("Проверить переход на страницу авторизации (отображается заголовок \"Вход\")")
    public boolean isTitleLoginPageDisplayed() {
        return driver.findElement(titleLoginPage).isDisplayed();
    }

    @Step("Ввести адрес электронной почты в поле \"Email\"")
    public void setEmail(String email) {
        driver.findElement(emailFieldLoginPage).sendKeys(email);
    }

    @Step("Ввести пароль в поле \"Пароль\"")
    public void setPassword(String password) {
        driver.findElement(passwordFieldLoginPage).sendKeys(password);
    }

    @Step("Кликнуть по кнопке \"Войти\"")
    public void clickLoginButton() {
        driver.findElement(loginButtonLoginPage).click();
    }

    @Step("Кликнуть по кнопке \"Зарегистироваться\"")
    public void clickRegisterButton() {
        driver.findElement(registerButtonLoginPage).click();
    }

    @Step("Кликнуть по кнопке \"Восстановить пароль\"")
    public void clickForgotPasswordButton() {
        driver.findElement(forgotPasswordButtonLoginPage).click();
    }

    @Step("Ввести в форму Входа данные зарегистрированного пользователя")
    public void setUserForLogin(String email, String password) {
        setEmail(email);
        setPassword(password);
    }
}
