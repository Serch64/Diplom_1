package praktikum;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import static praktikum.IngredientType.*;

@RunWith(Parameterized.class)
public class IngredientTest {
    private final IngredientType type;
    private final String name;
    private final float price;
    private Ingredient ingredient;

    public IngredientTest(IngredientType type, String name, float price) {
        this.type = type;
        this.name = name;
        this.price = price;
    }

    @Parameterized.Parameters(name = "Тест {index}. Тип ингредиента: {0}, ингредиент: {1}, цена: {2}")
    public static Object[][] getTestData() {
        return new Object[][]{
                {SAUCE, "cheese sauce", 123.23F},
                {FILLING, "steak", 325.74F},
                {SAUCE, "szechuan sauce", 999.99F},
                {FILLING, "frog", 500.11F}
        };
    }
    @Test
    public void getPriceTest() {
        ingredient = new Ingredient(type, name, price);
        Assert.assertEquals(price, ingredient.getPrice(), 0.01);
    }
    @Test
    public void getNameTest() {
        ingredient = new Ingredient(type, name, price);
        Assert.assertEquals(name, ingredient.getName());
    }
    @Test
    public void getTypeTest() {
        ingredient = new Ingredient(type, name, price);
        Assert.assertEquals(type, ingredient.getType());
    }
}