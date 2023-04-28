package stellarburgers.pages_burger;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ProfileUserPage extends BasePage{
    //Кнопка "Профиль"
    private final By profileButton = By.xpath("//a[@href='/account/profile' and text()='Профиль']");

    //Кнопка "Конструктор"
    private final By constructorButton = By.xpath("//*[text()='Конструктор']");

    //"Логотип"
    private final By logoButton = By.xpath("//div[@class='AppHeader_header__logo__2D0X2']/a");

    //Кнопка "Выход"
    private final By logoutButton = By.xpath("//*[text()='Выход']");

    public ProfileUserPage(WebDriver driver) {
        super(driver);
    }

    @Step("Проверить переход в Личный кабинет (отображается кнопка \"Профиль\")")
    public boolean isProfileButtonDisplayed() {
        return driver.findElement(profileButton).isDisplayed();
    }

    @Step("Кликнуть по кнопке \"Конструктор\" в заголовке")
    public void clickConstructorButton() {
        driver.findElement(constructorButton).click();
    }

    @Step("Кликнуть по логотипу Stellar burgers в заголовке")
    public void clickLogoButton() {
        driver.findElement(logoButton).click();
    }

    @Step("Кликнуть по кнопке \"Выход\"")
    public void clickLogoutButton() {
        driver.findElement(logoutButton).click();
    }
}
