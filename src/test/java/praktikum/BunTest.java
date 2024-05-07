package praktikum;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

@RunWith(Parameterized.class)
public class BunTest {
    private static final float GET_PRICE_TEST_DELTA = 0.01F;
    private Bun bun;
    private final String name;
    private final float price;

    public BunTest(String name, float price) {
        this.name = name;
        this.price = price;
    }

    @Parameterized.Parameters(name = "Тест {index}. Имя булочки: {0}, цена: {1}")
    public static Object[][] getTestData() {
        return new Object[][]{
                {"white bun", 10F},
                {"black bun", 15.6F},
                {"grain bun", 19.99F},
        };
    }

    @Before
    public void createBun() {
        bun = new Bun(name, price);
    }
    @Test
    public void getNameTest() {
        Assert.assertEquals(name, bun.getName());
    }
    @Test
    public void getPriceTest() {
        Assert.assertEquals(price, bun.getPrice(), GET_PRICE_TEST_DELTA);
    }
}
