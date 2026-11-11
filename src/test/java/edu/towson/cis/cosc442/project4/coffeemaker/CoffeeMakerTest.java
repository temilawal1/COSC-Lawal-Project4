package edu.towson.cis.cosc442.project4.coffeemaker;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

public class CoffeeMakerTest {

    private CoffeeMaker coffeeMaker;
    private Recipe recipe;
    private Recipe recipe2;
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

        recipe2 = new Recipe();
        recipe2.setName("Recipe2");
        recipe2.setPrice(4);
        recipe2.setAmtCoffee(3);
        recipe2.setAmtMilk(1);
        recipe2.setAmtSugar(2);
        recipe2.setAmtChocolate(2);
    }

    @Test
    public void addRecipeValidTest() {

        assertTrue(coffeeMaker.addRecipe(recipe));

    }

    @Test
    public void addRecipeAlreadyExistsTest() {

        coffeeMaker.addRecipe(recipe);

        Recipe duplicate_recipe = new Recipe();
        duplicate_recipe.setName("Recipe");
        duplicate_recipe.setPrice(4);

        assertFalse(coffeeMaker.addRecipe(duplicate_recipe));
    }

    @Test
    public void addRecipeNoSpaceTest() {

        for (int i = 0; i < 3 /* max num recipes */; i++) {
            Recipe filler_recipe = new Recipe();
            filler_recipe.setName("Recipe_" + i);
            filler_recipe.setPrice(4);

            assertTrue(coffeeMaker.addRecipe(filler_recipe));

        }

        assertFalse(coffeeMaker.addRecipe(recipe2));
    }

    @Test
    public void deleteRecipeValidTest() {

        coffeeMaker.addRecipe(recipe);
        assertTrue(coffeeMaker.deleteRecipe(recipe));
    }

    @Test
    public void deleteRecipeDoesntExistTest() {

        assertFalse(coffeeMaker.deleteRecipe(recipe2));
        assertFalse(coffeeMaker.deleteRecipe(null));
    }

    @Test
    public void editRecipeTest() {

        coffeeMaker.addRecipe(recipe);
        assertTrue(coffeeMaker.editRecipe(recipe, recipe2));

        coffeeMaker.addRecipe(recipe2);
        Recipe duplicate_recipe = new Recipe();
        duplicate_recipe.setName("Recipe2");

        assertFalse(coffeeMaker.editRecipe(recipe, duplicate_recipe));
        // shouldnt work cuz recipe2 already exists
    }

    /* 
    @Test
    public void addInventoryTest() {

        int coffee = 3;
        int milk = 2;
        int sugar = 2;
        int chocolate = 2;

        assertTrue(coffeeMaker.addInventory(coffee, milk, sugar, chocolate));

        assertEquals(18, coffeeMaker.checkInventory().getCoffee());
        assertEquals(17, coffeeMaker.checkInventory().getMilk());
        assertEquals(17, coffeeMaker.checkInventory().getSugar());
        assertEquals(17, coffeeMaker.checkInventory().getChocolate());
        // checking if inventory actually increased
    }
        

    @ParameterizedTest
    @CsvSource({
            "-1, 0, 0, 0",
            "0, -1, 0, 0",
            "0, 0, -1, 0",
            "0, 0, 0, -1"
    })
    public void addInventoryInvalidAmountTest(int coffee, int milk, int sugar, int chocolate) {
        assertFalse(coffeeMaker.addInventory(coffee, milk, sugar, chocolate));
    }

    @ParameterizedTest
    @CsvSource({
            "0, 2, 3, 4",
            "2, 0, 3, 4",
            "2, 3, 0, 4",
            "2, 3, 4, 0"
    })
    void addInventoryZeroAmountTest(
            int coffee, int milk, int sugar, int chocolate) {

        assertTrue(coffeeMaker.addInventory(coffee, milk, sugar, chocolate));
    }

    */
    @Test
    public void checkInventoryTest() {

        assertEquals(
                "Coffee: " + inventory.getCoffee() + "\n" + "Milk: " + inventory.getMilk() + "\n" + "Sugar: "
                        + inventory.getSugar() + "\n" + "Chocolate: " + inventory.getChocolate() + "\n",
                coffeeMaker.checkInventory().toString());
    }

    @Test
    public void makeCoffeeTest() {

        int amt_paid = 10;
        int change = coffeeMaker.makeCoffee(recipe, amt_paid);

        assertEquals(6, change);
        // if paid amt is sufficient
        // if ingredients available
    }

    @ParameterizedTest 
    @ValueSource (ints = {4, 10})
    public void makeCoffeeTest(int amt_paid) {

        int change = coffeeMaker.makeCoffee(recipe, amt_paid);

        int expected_change = amt_paid - recipe.getPrice();

        assertEquals(expected_change, change);

        assertEquals(14, coffeeMaker.checkInventory().getCoffee());
        assertEquals(13, coffeeMaker.checkInventory().getMilk());
        assertEquals(12, coffeeMaker.checkInventory().getSugar());
        assertEquals(14, coffeeMaker.checkInventory().getChocolate());
        // checking if inventory actually increased

    }

    @Test
    public void makeCoffeeInsufficientFundsTest() {

        int amt_paid = 3;
        int change = coffeeMaker.makeCoffee(recipe, amt_paid);

        assertEquals(3, change); // returns amt paid if insuff funds
        // if paid amt is sufficient
        // if ingredients available
    }

    @Test
    public void makeCoffeeNoIngredientsTest() {

        int amt_paid = 10;
        recipe.setAmtCoffee(20);
        int change = coffeeMaker.makeCoffee(recipe, amt_paid);

        assertEquals(10, change);

        // if paid amt is sufficient
        // if ingredients available
    }

    @Test
    public void getRecipeTest() {
        // returns array of recipes stored in coffee maker

        coffeeMaker.addRecipe(recipe);
        coffeeMaker.addRecipe(recipe2);

        Recipe[] recipes = coffeeMaker.getRecipes();
        assertEquals(recipe, recipes[0]);
        assertEquals(recipe2, recipes[1]);
    }

    @Test
    public void getRecipeByNameTest() {
        // finds recipe with name and return it
        // empty recipe if no recipes

        coffeeMaker.addRecipe(recipe);

        Recipe recipe_name = coffeeMaker.getRecipeForName(recipe.getName());

        assertEquals(recipe, recipe_name);
    }

    @Test
    public void getRecipeByNameDoesntExistTest() {
        coffeeMaker.addRecipe(recipe);

        Recipe recipe_name = coffeeMaker.getRecipeForName("doesnt exist");

        assertEquals(null, recipe_name.getName());
    }
}
