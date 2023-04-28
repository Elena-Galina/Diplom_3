import io.restassured.response.Response;
import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import stellarburgers.user_api.User;
import stellarburgers.user_api.UserClient;

import java.time.Duration;

import static stellarburgers.user_api.UserGenerator.randomeUser;

// для выполнения тестов, в которых необходимо предварительно создать тестового пользователя
public class BaseWithUserTest {
    protected WebDriver driver;
    protected String userAccessToken;
    protected static User user;

    @Before
    public void setup() {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");        // Google Chrome
//        System.setProperty("webdriver.chrome.driver", "src/test/resources/yandexdriver.exe");            // Yandex Browser
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--no-sandbox", "--headless", "--disable-dev-shm-usage");
//        options.setBinary("C:/Users/user/AppData/Local/Yandex/YandexBrowser/Application/browser.exe");   // Yandex Browser

        driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://stellarburgers.nomoreparties.site/");

        user = randomeUser();
        Response newUser = UserClient.newUserCreate(user);
        userAccessToken = UserClient.getUserAccessToken(newUser);
    }

    @After
    public void tearDown() {
        if (userAccessToken != null) {
            UserClient.userDelete(userAccessToken);
        }
        driver.quit();
    }
}
