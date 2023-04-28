import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.time.Duration;

// для выполнения тестов, где не требуется предварительное создание тестового пользователя
public class BaseTest {
    protected WebDriver driver;

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
    }

    @After
    public void tearDown() {
        driver.quit();
    }
}
