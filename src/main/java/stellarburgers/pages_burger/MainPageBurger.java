package stellarburgers.pages_burger;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class MainPageBurger extends BasePage {

    //Кнопка "Личный кабинет"
    private final By personalAccountButton = By.xpath("//*[text()='Личный Кабинет']");
    //Кнопка "Войти в аккаунт"
    private final By loginButton = By.xpath("//button[text()='Войти в аккаунт']");
    //Кнопка "Оформить заказ"
    private final By orderButton = By.xpath("//button[text()='Оформить заказ']");
    //Заголовок главной страницы Конструктора
    private final By titlePage = By.xpath("//*[text()='Соберите бургер']");
    //Вкладка раздела "Булки"
    private final By bunButton = By.xpath("//span[text()='Булки']");
    private final By bunActiveButton = By.xpath("//div[@class = 'tab_tab__1SPyG tab_tab_type_current__2BEPc pt-4 pr-10 pb-4 pl-10 noselect']/span[text()='Булки']");
    //Вкладка раздела "Соусы"
    private final By sauceButton = By.xpath("//span[text()='Соусы']");
    private final By sauceActiveButton = By.xpath("//div[@class = 'tab_tab__1SPyG tab_tab_type_current__2BEPc pt-4 pr-10 pb-4 pl-10 noselect']/span[text()='Соусы']");
    //Вкладка раздела "Начинки"
    private final By fillingButton = By.xpath("//span[text()='Начинки']");
    private final By fillingActiveButton = By.xpath("//div[@class = 'tab_tab__1SPyG tab_tab_type_current__2BEPc pt-4 pr-10 pb-4 pl-10 noselect']/span[text()='Начинки']");

    public MainPageBurger(WebDriver driver) {
        super(driver);
    }

    @Step("Кликнуть по кнопке \"Личный кабинет\" в заголовке")
    public void clickPersonalAccountButton() {
        driver.findElement(personalAccountButton).click();
    }

    @Step("Кликнуть по кнопке \"Войти в аккаунт\"")
    public void clickLoginButton() {
        driver.findElement(loginButton).click();
    }

    @Step("Кликнуть по вкладке раздела \"Булки\"")
    public void clickBunButton() {
        driver.findElement(bunButton).click();
    }

    @Step("Проверить переход к разделу \"Булки\"")
    public boolean isBunActive() {
        return driver.findElement(bunActiveButton).isDisplayed();
    }

    @Step("Кликнуть по вкладке раздела \"Соусы\"")
    public void clickSauceButton() {
        driver.findElement(sauceButton).click();
    }

    @Step("Проверить переход к разделу \"Соусы\"")
    public boolean isSauceActive() {
        return driver.findElement(sauceActiveButton).isDisplayed();
    }

    @Step("Кликнуть по вкладке раздела \"Начинки\"")
    public void clickFillingButton() {
        driver.findElement(fillingButton).click();
    }

    @Step("Проверить переход к разделу \"Начинки\"")
    public boolean isFillingActive() {
        return driver.findElement(fillingActiveButton).isDisplayed();
    }

    @Step("Проверить переход на главную страницу (отображается надпись \"Соберите бургер\")")
    public boolean isTitlePageDisplayed() {
        return driver.findElement(titlePage).isDisplayed();
    }

    @Step("Проверить наличие кнопки \"Оформить заказ\" на главной странице")
    public boolean isOrderButtonDisplayed() {
        return driver.findElement(orderButton).isDisplayed();
    }
}

