package praktikum;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class BunTest {
    private Bun bun;
    private String name;
    private float price;

    @Before
    public void createBun() {
        name = "white bun";
        price = 10.25F;
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
