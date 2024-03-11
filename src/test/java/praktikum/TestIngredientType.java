package praktikum;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class TestIngredientType {

    @Test
    public void TestValueFilling() {
        assertEquals("FILLING", IngredientType.FILLING.name());
    }

    @Test
    public void TestValueSauce() {
        assertEquals("SAUCE", IngredientType.SAUCE.name());
    }
}
