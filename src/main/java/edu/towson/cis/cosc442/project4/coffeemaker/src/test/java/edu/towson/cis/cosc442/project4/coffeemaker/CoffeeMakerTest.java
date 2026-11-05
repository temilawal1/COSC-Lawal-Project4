package edu.towson.cis.cosc442.project4.coffeemaker;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class CoffeeMakerTest {

    private CoffeeMaker coffeeMaker;
    private Recipe recipe;
    private Inventory inventory;

    @BeforeEach
    public void setUp() {
        coffeeMaker = new CoffeeMaker();
        inventory = new Inventory();

        recipe = new Recipe();
        recipe.setName("Recipe");
        recipe.setPrice(4);
        recipe.setAmtCoffee(1);
        recipe.setAmtMilk(2);
        recipe.setAmtSugar(3);
        recipe.setAmtChocolate(1);
    }

    @Test
    public void addRecipeValidTest() {

        assertTrue(coffeeMaker.addRecipe(recipe));

    }

    @Test
    public void addRecipeAlreadyExistsTest() {

        Recipe recipe2 = new Recipe();
        recipe2.setName("Recipe");
        recipe2.setPrice(4);
        recipe2.setAmtCoffee(1);
        recipe2.setAmtMilk(2);
        recipe2.setAmtSugar(3);
        recipe2.setAmtChocolate(1);

        coffeeMaker.addRecipe(recipe);

        assertFalse(coffeeMaker.addRecipe(recipe2));
    }

    @Test
    public void addRecipeNoSpaceTest() {

        for (int i = 0; i < 4 /* max num recipes */; i++) {
            Recipe recipe = new Recipe();
            recipe.setName("Recipe" + i);
            recipe.setPrice(4);

            assertTrue(coffeeMaker.addRecipe(recipe));

        }

        Recipe recipe2 = new Recipe();
        recipe2.setName("Recipe2");
        recipe2.setPrice(4);

        assertFalse(coffeeMaker.addRecipe(recipe2));
    }

    @Test
    public void deleteRecipeValidTest() {

        coffeeMaker.addRecipe(recipe);
        assertTrue(coffeeMaker.deleteRecipe(recipe));
    }

    @Test
    public void deleteRecipeDoesntExistTest() {

        Recipe recipe2 = new Recipe();
        recipe2.setName("Recipe2");
        recipe2.setPrice(4);

        assertFalse(coffeeMaker.deleteRecipe(recipe2));
    }

    @Test
    public void editRecipeTest() {

        Recipe recipe2 = new Recipe();
        recipe2.setName("Recipe2");
        recipe2.setPrice(4);

        coffeeMaker.addRecipe(recipe);

        assertTrue(coffeeMaker.editRecipe(recipe, recipe2));
    }

    @Test
    public void addInventoryTest() {

        int coffee = 3;
        int milk = 2;
        int sugar = 2;
        int chocolate = 2;

        assertTrue(coffeeMaker.addInventory(coffee, milk, sugar, chocolate));
    }

    @Test
    public void checkInventoryTest() {

        assertEquals("Coffee: " + inventory.getCoffee() + "\n" + "Milk: " + inventory.getMilk() + "\n" + "Sugar: " + inventory.getSugar() + "\n" + "Chocolate: " + inventory.getChocolate() + "\n",
                coffeeMaker.checkInventory().toString());
    }

    @Test
    public void makeCoffeeTest() {

    }

    @Test
    public void getRecipeTest() {

    }

    @Test
    public void getRecipeByNameTest() {

    }

}
