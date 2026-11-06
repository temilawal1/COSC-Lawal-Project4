package edu.towson.cis.cosc442.project4.coffeemaker;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class RecipeTest {

    private Recipe recipe;
    private Recipe recipe2;

    @BeforeEach
    public void setUp() {
        recipe = new Recipe();
        recipe2 = new Recipe();
    }

    @Test
    public void testGetAmtChocolate() {
        recipe.setAmtChocolate(2);
        assertEquals(2, recipe.getAmtChocolate());
    }

    @Test
    public void testGetAmtCoffee() {
        recipe.setAmtCoffee(2);
        assertEquals(2, recipe.getAmtCoffee());
    }

    @Test
    public void testGetAmtMilk() {
        recipe.setAmtMilk(2);
        assertEquals(2, recipe.getAmtMilk());
    }

    @Test
    public void testGetAmtSugar() {
        recipe.setAmtSugar(2);
        assertEquals(2, recipe.getAmtSugar());
    }

    @Test
    public void testGetName() {
        recipe.setName("Recipe");
        assertEquals("Recipe", recipe.getName());
    }

    @Test
    public void testGetPrice() {
        recipe.setPrice(5);
        assertEquals(5, recipe.getPrice());
    }

    @Test
    public void testSetAmtChocolate() {
        recipe.setAmtChocolate(2);
        assertEquals(2, recipe.getAmtChocolate());

        recipe.setAmtChocolate(0);
        assertEquals(0, recipe.getAmtChocolate());

        recipe.setAmtChocolate(-2);
        assertEquals(0, recipe.getAmtChocolate());
    }

    @Test
    public void testSetAmtCoffee() {
        recipe.setAmtCoffee(2);
        assertEquals(2, recipe.getAmtCoffee());

        recipe.setAmtCoffee(0);
        assertEquals(0, recipe.getAmtCoffee());

        recipe.setAmtCoffee(-2);
        assertEquals(0, recipe.getAmtCoffee());
    }

    @Test
    public void testSetAmtMilk() {
        recipe.setAmtMilk(2);
        assertEquals(2, recipe.getAmtMilk());

        recipe.setAmtMilk(0);
        assertEquals(0, recipe.getAmtMilk());

        recipe.setAmtMilk(-2);
        assertEquals(0, recipe.getAmtMilk());
    }

    @Test
    public void testSetAmtSugar() {
        recipe.setAmtSugar(2);
        assertEquals(2, recipe.getAmtSugar());

        recipe.setAmtSugar(0);
        assertEquals(0, recipe.getAmtSugar());

        recipe.setAmtSugar(-2);
        assertEquals(0, recipe.getAmtSugar());
    }

    @Test
    public void testSetName() {
        recipe.setName("Recipe");
        assertEquals("Recipe", recipe.getName());
    }

    @Test
    public void testSetPrice() {
        recipe.setPrice(5);
        assertEquals(5, recipe.getPrice());
        recipe.setPrice(-5);
        assertEquals(0, recipe.getPrice());
    }

    @Test
    public void testEqualsMethod() {
        recipe.setName("Recipe");
        recipe2.setName("Recipe");
        assertTrue(recipe.equals(recipe2));

    }

    @Test
    public void testEqualsMethodDifferentName() {

        recipe.setName("Recipe");
        recipe2.setName("Recipe2");
        assertFalse(recipe.equals(recipe2));

    }

    @Test
    public void testEqualsMethodNullName() {

        recipe2.setName("Recipe2");
        assertFalse(recipe.equals(recipe2));

    }

    @Test
    public void testToString() {
        recipe.setName("Recipe");
        assertEquals("Recipe", recipe.toString());
    }
}
