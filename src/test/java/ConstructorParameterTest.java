import io.qameta.allure.Description;
import io.qameta.allure.junit4.DisplayName;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import stellarburgers.IngredientType;
import stellarburgers.pages_burger.MainPageBurger;

import static org.junit.Assert.assertTrue;
import static stellarburgers.IngredientType.*;

@RunWith(Parameterized.class)
public class ConstructorParameterTest extends BaseTest {
    public IngredientType type;

    public ConstructorParameterTest(IngredientType type) {
        this.type = type;
    }

    @Parameterized.Parameters(name = "Тестовые данные: {0}")
    public static Object[][] getListItem() {
        return new Object[][]{
                {BUN},
                {SAUCE},
                {FILLING}
        };
    }

    @Test
    @DisplayName("Проверка переходов к разделам \"Конструктора\" на главной странице")
    @Description("Параметризованный тест проверяет переходы к разделам \"Конструктора\": \"Булки\", \"Соусы\", \"Начинки\".")
    public void isActiveConstructorTypeIngredientTest() {
        MainPageBurger mainPageBurger = new MainPageBurger(driver);

        switch (type) {
            case BUN:
                mainPageBurger.clickSauceButton();
                mainPageBurger.clickBunButton();
                assertTrue("Переход к разделу \"Булки\" не произошёл", mainPageBurger.isBunActive());
                break;
            case SAUCE:
                mainPageBurger.clickSauceButton();
                assertTrue("Переход к разделу \"Соусы\" не произошёл", mainPageBurger.isSauceActive());
                break;
            case FILLING:
                mainPageBurger.clickFillingButton();
                assertTrue("Переход к разделу \"Начинки\" не произошёл", mainPageBurger.isFillingActive());
                break;
        }
    }
}
