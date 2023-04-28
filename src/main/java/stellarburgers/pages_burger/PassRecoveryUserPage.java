package stellarburgers.pages_burger;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class PassRecoveryUserPage extends BasePage {

    //Заголовок страницы Восстановления пароля
    private final By titlePassRecoveryPage = By.xpath(".//*[text()='Восстановление пароля']");

    //Кнопка "Войти"
    private final By loginButtonPassRecoveryPage = By.xpath(".//a[@href = '/login' and text()='Войти']");

    public PassRecoveryUserPage(WebDriver driver) {
        super(driver);
    }

    @Step("Проверить переход на страницу Восстановления пароля (отображается заголовок \"Восстановление пароля\")")
    public boolean isTitlePassRecoveryDisplayed() {
        return driver.findElement(titlePassRecoveryPage).isDisplayed();
    }

    @Step("Кликнуть по кнопке \"Войти\"")
    public void clickLoginButton() {
        driver.findElement(loginButtonPassRecoveryPage).click();
    }
}
