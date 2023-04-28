package stellarburgers.pages_burger;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class RegisterUserPage extends BasePage {
    //Заголовок страницы регистрации
    private final By titleRegisterPage = By.xpath("//*[text()='Регистрация']");

    //Поле ввода "Имя"
    private final By nameFieldRegisterPage = By.xpath("//label[text()='Имя']//following-sibling::input[@name='name']");

    //Поле ввода "Email"
    private final By emailFieldRegisterPage = By.xpath("//label[text()='Email']//following-sibling::input[@name='name']");

    //Поле ввода "Пароль"
    private final By passwordFieldRegisterPage = By.xpath("//input[@name='Пароль']");

    //Кнопка "Войти"
    private final By loginButtonRegisterPage = By.xpath("//a[@href = '/login' and text()='Войти']");

    //Кнопка "Зарегистироваться"
    private final By registerButtonRegisterPage = By.xpath("//button[text()='Зарегистрироваться']");

    //Сообщение об ошибке "Некорректный пароль"
    private final By errorMessage = By.xpath("//*[@class = 'input__error text_type_main-default']");

    public RegisterUserPage(WebDriver driver) {
        super(driver);
    }

    @Step("Проверить отображение заголовка \"Регистрация\"")
    public boolean isTitleLoginPageDisplayed() {
        return driver.findElement(titleRegisterPage).isDisplayed();
    }

    @Step("Ввести имя в поле \"Имя\"")
    public void setName(String name) {
        driver.findElement(nameFieldRegisterPage).sendKeys(name);
    }

    @Step("Ввести адрес электронной почты в поле \"Email\"")
    public void setEmail(String email) {
        driver.findElement(emailFieldRegisterPage).sendKeys(email);
    }

    @Step("Ввести пароль в поле \"Пароль\"")
    public void setPassword(String password) {
        driver.findElement(passwordFieldRegisterPage).sendKeys(password);
    }

    @Step("Кликнуть по кнопке \"Зарегистироваться\"")
    public void clickRegisterButton() {
        driver.findElement(registerButtonRegisterPage).click();
    }

    @Step("Кликнуть по кнопке \"Войти\"")
    public void clickLoginButton() {
        driver.findElement(loginButtonRegisterPage).click();
    }

    @Step("Проверить появление сообщения об ошибке при вводе некорректного пароля")
    public boolean isErrorMessageVisible() {
        return driver.findElement(errorMessage).isDisplayed();
    }

    @Step("Ввести в форму регистрации данные нового пользователя")
    public void setUser(String name, String email, String password) {
        setName(name);
        setEmail(email);
        setPassword(password);
    }
}

