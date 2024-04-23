package praktikum;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

@RunWith(Parameterized.class)
public class BunTest {
    private Bun bun;
    private final String name;
    private  final float price;

    public BunTest(String name, float price) {
        this.name = name;
        this.price = price;
    }

    @Parameterized.Parameters(name = "Тест {index}. Имя булочки: {0}, цена: {1}")
    public static Object[][] getTestData() {
        return new Object[][]{
                {"white bun", 10.25F},
                {"black bun", 15.62F},
                {"grain bun", 20.11F},
                {"sesame bun", 26.35F}
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
        Assert.assertEquals(price, bun.getPrice(), 0.01);
    }
}
