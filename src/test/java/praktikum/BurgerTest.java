package praktikum;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import static praktikum.IngredientType.*;

@RunWith(MockitoJUnitRunner.class)
public class BurgerTest {
    private static final float BUN_GET_PRICE_STUB = 50.99F;
    private static final float INGREDIENT_GET_PRICE_STUB_1 = 99.02F;
    private static final float INGREDIENT_GET_PRICE_STUB_2 = 75.50F;
    private static final String BUN_GET_NAME_STUB = "Stub Bun";
    private static final String INGREDIENT_GET_NAME_STUB_1 = "stub ingredient 1";
    private static final String INGREDIENT_GET_NAME_STUB_2 = "stub ingredient 2";
    private static final float BURGER_GET_PRICE_STUB = 111.50F;
    private Burger burger;
    @Mock
    private Bun bunMock;
    @Mock
    private Ingredient ingredientMock1;
    @Mock
    private Ingredient ingredientMock2;

    public float getExpectedPrice() {
        return BUN_GET_PRICE_STUB * 2 + INGREDIENT_GET_PRICE_STUB_1 + INGREDIENT_GET_PRICE_STUB_2;
    }
    public String getExpectedReceipt() {
        StringBuilder receipt = new StringBuilder(String.format("(==== %s ====)%n", BUN_GET_NAME_STUB));
        receipt.append(String.format("= %s %s =%n", SAUCE.toString().toLowerCase(), INGREDIENT_GET_NAME_STUB_1));
        receipt.append(String.format("= %s %s =%n", FILLING.toString().toLowerCase(), INGREDIENT_GET_NAME_STUB_2));
        receipt.append(String.format("(==== %s ====)%n", BUN_GET_NAME_STUB));
        receipt.append(String.format("%nPrice: %f%n", BURGER_GET_PRICE_STUB));

        return receipt.toString();
    }
    @Before
    public void createBurger() {
        burger = new Burger();
    }
    @Test
    public void addIngredientTest() {
        burger.addIngredient(ingredientMock1);
        Assert.assertFalse(burger.ingredients.isEmpty());
    }
    @Test
    public void removeIngredientTest() {
        burger.addIngredient(ingredientMock1);
        burger.removeIngredient(0);
        Assert.assertTrue(burger.ingredients.isEmpty());
    }
    @Test
    public void moveIngredientTest() {
        burger.addIngredient(ingredientMock1);
        burger.addIngredient(ingredientMock2);
        burger.moveIngredient(0, 1);
        Assert.assertEquals(ingredientMock1,  burger.ingredients.get(1));
    }
    @Test
    public void getPriceTest() {
        burger.setBuns(bunMock);
        burger.addIngredient(ingredientMock1);
        burger.addIngredient(ingredientMock2);
        Mockito.when(bunMock.getPrice()).thenReturn(BUN_GET_PRICE_STUB);
        Mockito.when(ingredientMock1.getPrice()).thenReturn(INGREDIENT_GET_PRICE_STUB_1);
        Mockito.when(ingredientMock2.getPrice()).thenReturn(INGREDIENT_GET_PRICE_STUB_2);
        Assert.assertEquals(getExpectedPrice(),  burger.getPrice(), 0.01F);
    }
    @Test
    public void getReceiptTest() {
        burger.setBuns(bunMock);
        burger.addIngredient(ingredientMock1);
        burger.addIngredient(ingredientMock2);
        Mockito.when(bunMock.getName()).thenReturn(BUN_GET_NAME_STUB);
        Mockito.when(ingredientMock1.getType()).thenReturn(SAUCE);
        Mockito.when(ingredientMock2.getType()).thenReturn(FILLING);
        Mockito.when(ingredientMock1.getName()).thenReturn(INGREDIENT_GET_NAME_STUB_1);
        Mockito.when(ingredientMock2.getName()).thenReturn(INGREDIENT_GET_NAME_STUB_2);
        Mockito.when( burger.getPrice()).thenReturn(BURGER_GET_PRICE_STUB);
        Assert.assertEquals(getExpectedReceipt(),  burger.getReceipt());
    }
}
