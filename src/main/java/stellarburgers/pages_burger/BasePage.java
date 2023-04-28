package stellarburgers.pages_burger;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;

public class BasePage {
    protected WebDriver driver;
    public static final String URL_MAIN_PAGE = "https://stellarburgers.nomoreparties.site/";
    public static final String URL_LOGIN_PAGE = "https://stellarburgers.nomoreparties.site/login";
    public static final String URL_REGISTER_PAGE = "https://stellarburgers.nomoreparties.site/register";
    public static final String URL_PROFILE_USER_PAGE = "https://stellarburgers.nomoreparties.site/account/profile";

    public BasePage(WebDriver driver) {
        this.driver = driver;
    }
    @Step("Проверить URL текущей страницы")
    public String getUrlPage() {
        return driver.getCurrentUrl();
    }

}
