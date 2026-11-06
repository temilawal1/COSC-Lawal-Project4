package edu.towson.cis.cosc442.project4.coffeemaker;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class InventoryTest {

    private Inventory inventory;

    @BeforeEach
    public void setUp() {
        inventory = new Inventory();
    }

    @Test
    public void testEnoughIngredients() {
        Recipe recipe = new Recipe();
        recipe.setAmtCoffee(5);
        recipe.setAmtMilk(5);
        recipe.setAmtSugar(5);
        recipe.setAmtChocolate(5);

        assertTrue(inventory.enoughIngredients(recipe));

    }

    @Test
    public void testNotEnoughIngredients() {
        
        Recipe recipe = new Recipe();

        recipe.setAmtCoffee(20);
        recipe.setAmtMilk(20);
        recipe.setAmtSugar(20);
        recipe.setAmtChocolate(20);
        assertFalse(inventory.enoughIngredients(recipe));
    }

    @Test
    public void testExactIngredients() {
        
        Recipe recipe = new Recipe();
        
        recipe.setAmtCoffee(15);
        recipe.setAmtMilk(15);
        recipe.setAmtSugar(15);
        recipe.setAmtChocolate(15);
        assertTrue(inventory.enoughIngredients(recipe));
    }

    @Test
    public void testGetChocolate() {
        assertEquals(15, inventory.getChocolate());
    }

    @Test
    public void testGetCoffee() {
        assertEquals(15, inventory.getCoffee());
    }

    @Test
    public void testGetMilk() {
        assertEquals(15, inventory.getMilk());
    }

    @Test
    public void testGetSugar() {
        assertEquals(15, inventory.getSugar());
    }

    @ParameterizedTest
    @ValueSource(ints = { 0, 15, 20 })
    public void testSetCoffee(int amt) {
        inventory.setCoffee(amt);
        assertEquals(amt, inventory.getCoffee());
    }

    @ParameterizedTest
    @ValueSource(ints = { 0, 15, 20 })
    public void testSetMilk(int amt) {
        inventory.setMilk(amt);
        assertEquals(amt, inventory.getMilk());
    }

    @ParameterizedTest
    @ValueSource(ints = { 0, 15, 20 })
    public void testSetSugar(int amt) {
        inventory.setSugar(amt);
        assertEquals(amt, inventory.getSugar());
    }

    @ParameterizedTest
    @ValueSource(ints = { 0, 15, 20})
    public void testSetChocolate(int amt) {
        inventory.setChocolate(amt);
        assertEquals(amt, inventory.getChocolate());
    }

    @Test
    public void testSetCoffeeInvalidAmt() {
        inventory.setCoffee(-5);
        assertEquals(0, inventory.getCoffee());
    }

    @Test
    public void testSetMilkInvalidAmt() {
        inventory.setMilk(-5);
        assertEquals(0, inventory.getMilk());
    }

    @Test
    public void testSetSugarInvalidAmt() {
        inventory.setSugar(-5);
        assertEquals(0, inventory.getSugar());
    }

    @Test
    public void testSetChocolateInvalidAmt() {
        inventory.setChocolate(-5);
        assertEquals(0, inventory.getChocolate());
    }

    @Test
    public void testToString() {
        String inventory_toString = "Coffee: 15\n" + "Milk: 15\n" + "Sugar: 15\n" + "Chocolate: 15\n";

        assertEquals(inventory_toString, inventory.toString());
    }
}
