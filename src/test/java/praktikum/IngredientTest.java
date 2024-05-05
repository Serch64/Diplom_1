package praktikum;

import org.junit.Assert;
import org.junit.Before;
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
                {FILLING, "steak", 325F},
        };
    }
    @Before
    public void createIngredient() {
        ingredient = new Ingredient(type, name, price);
    }
    @Test
    public void getPriceTest() {
        Assert.assertEquals(price, ingredient.getPrice(), 0.01);
    }
    @Test
    public void getNameTest() {
        Assert.assertEquals(name, ingredient.getName());
    }
    @Test
    public void getTypeTest() {
        Assert.assertEquals(type, ingredient.getType());
    }
}
