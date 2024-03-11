package praktikum;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class TestBun {

    private Bun bun;
    private final String name;
    private final float price;
    private final static double DELTA = 0.0f;

    @Before
    public void setUp() {
        bun = new Bun(name, price);
    }

    public TestBun(String name, float price) {
        this.name = name;
        this.price = price;
    }

    @Parameterized.Parameters()
    public static Object[][] getNameAndPrice() {
        return new Object[][] {
                {null, (float) 0},
                {"BigBlackBurger", (float) 100},
                {"746228", (float) 150.00},

        };
    }

    @Test
    public void TestGetName() {
        assertEquals("Некорректное имя булочки", name, bun.getName());
    }

    @Test
    public void TestGetPrice() {
        assertEquals("Некорректная цена булочки", price, bun.getPrice(), DELTA);
    }
}