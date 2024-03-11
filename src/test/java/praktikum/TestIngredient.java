package praktikum;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class TestIngredient {

    private Ingredient ingredient;
    private static IngredientType type;
    private final String name;
    private final float price;
    private final static double DELTA = 0.0f;

    @Before
    public void setUp() {
        ingredient = new Ingredient(type, name, price);
    }

    public TestIngredient(IngredientType type, String name, float price) {
        this.type = type;
        this.name = name;
        this.price = price;
    }

    @Parameterized.Parameters()
    public static Object[][] getTypeNameAndPrice() {
        return new Object[][] {
                {type.SAUCE, "Sausage", (float) 60.00},
                {type.FILLING, "Ketchup", (float) 20.00}
        };
    }

    @Test
    public void TestGetPrice() {
        assertEquals("Некорректная цена ингредиентов", price, ingredient.getPrice(), DELTA);
    }

    @Test
    public void TestGetName() {
        assertEquals("Некорректное имя ингредианта", name, ingredient.getName());
    }

    @Test
    public void TestGetType() {
        assertEquals("Некорректный тип ингредиента", type, ingredient.getType());
    }
}