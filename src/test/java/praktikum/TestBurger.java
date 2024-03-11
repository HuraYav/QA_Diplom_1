package praktikum;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

@RunWith(MockitoJUnitRunner.class)
public class TestBurger {

    @Mock
    Bun bun;
    private Burger burger;
    private final Ingredient newIngredientFirst = Mockito.mock(Ingredient.class);
    private final Ingredient newIngredientSecond = Mockito.mock(Ingredient.class);
    private final static String NAME_BUN = "Bread";
    private final static String NAME_INGREDIENT_FIRST = "Sausage";
    private final static String NAME_INGREDIENT_SECOND = "Ketchup";
    private final static double DELTA = 0.0f;

    @Before
    public void setUp() {
        burger = new Burger();
        burger.addIngredient(newIngredientFirst);
    }

    @Test
    public void TestAddIngredient() {
        List<Ingredient> listExpected = new ArrayList<>();
        listExpected.add(newIngredientFirst);
        assertEquals("Некорректный список ингредиентов", listExpected, burger.ingredients);
    }

    @Test
    public void TestRemoveIngredient() {
        burger.addIngredient(newIngredientSecond);
        burger.removeIngredient(0);
        List<Ingredient> listExpected = new ArrayList<>();
        listExpected.add(newIngredientSecond);
        assertEquals("Некорректный список ингредиентов", listExpected, burger.ingredients);
    }

    @Test
    public void TestMoveIngredient() {
        burger.addIngredient(newIngredientSecond);
        burger.moveIngredient(1, 0);
        List<Ingredient> listExpected = new ArrayList<>();
        listExpected.add(newIngredientSecond);
        listExpected.add(newIngredientFirst);
        assertEquals("Некорректный список ингредиентов", listExpected, burger.ingredients);
    }

    @Test
    public void TestGetPrice() {
        Mockito.when(newIngredientSecond.getPrice()).thenReturn((float) 50);
        burger.addIngredient(newIngredientSecond);
        Mockito.when(bun.getPrice()).thenReturn((float) 50);
        burger.setBuns(bun);
        float expectedPrice = (float) 150;
        assertEquals("Некорректная цена", expectedPrice, burger.getPrice(), DELTA);
    }

    @Test
    public void TestGetReceipt() {
        Mockito.when(newIngredientFirst.getType()).thenReturn(IngredientType.FILLING);
        Mockito.when(newIngredientSecond.getType()).thenReturn(IngredientType.SAUCE);
        Mockito.when(newIngredientFirst.getName()).thenReturn(NAME_INGREDIENT_FIRST);
        Mockito.when(newIngredientSecond.getName()).thenReturn(NAME_INGREDIENT_SECOND);
        Mockito.when(newIngredientFirst.getPrice()).thenReturn((float) 100);
        Mockito.when(newIngredientSecond.getPrice()).thenReturn((float) 50);

        burger.addIngredient(newIngredientSecond);
        Mockito.when(bun.getName()).thenReturn(NAME_BUN);
        burger.setBuns(bun);

        String receipt = burger.getReceipt();
        float price = burger.getPrice();
        String strPrice = Float.toString(price);
        String newStrPrice = strPrice.replace(".", ",");

        assertTrue("Некорректный рецепт бургера",
                receipt.contains(NAME_BUN)
                        && receipt.contains(NAME_INGREDIENT_FIRST)
                        && receipt.contains(NAME_INGREDIENT_SECOND)
                        && receipt.contains(newStrPrice));
    }
}