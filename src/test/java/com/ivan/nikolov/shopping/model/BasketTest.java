/**
 *
 */
package com.ivan.nikolov.shopping.model;

import java.util.List;
import java.util.Map;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;


/**
 * @author inikolov
 *
 */
public class BasketTest {

    private Basket basket;

    @Before
    public void initializeBasket() {
        this.basket = new Basket();
        this.basket.addItem(new Bread());
        this.basket.addItem(new Milk());
    }

    @Test
    public void removeItemByIndex() {
        Assert.assertNotNull(this.basket.removeItem(0));
        Assert.assertTrue(this.basket.getItems().size() == 1);
    }

    @Test
    public void removeItemByObject() {
        Assert.assertTrue(this.basket.removeItem(new Milk()));
        Assert.assertTrue(this.basket.getItems().size() == 1);
    }

    @Test
    public void addItem() {
        this.basket.addItem(new Soup());
        Assert.assertEquals(3, this.basket.getItems().size());
    }

    @Test
    public void subtotalWithNoDiscountedElements() {
        Assert.assertEquals(2.10, this.basket.getSubtotal(), 0);
    }

    @Test
    public void subtotalWithDiscountedElements() {
        this.basket.addItem(new Apples());
        Assert.assertEquals(3.10, this.basket.getSubtotal(), 0);
    }

    @Test
    public void totalWithNoDiscountedElements() {
        Assert.assertEquals(2.10, this.basket.getTotal(), 0);
    }

    @Test
    public void totalWithDiscountedElements() {
        this.basket.addItem(new Apples());
        Assert.assertEquals(3.0, this.basket.getTotal(), 0);
    }

    @Test
    public void discountsEmptyWhenNoDiscountedItems() {
        Assert.assertTrue(this.basket.getDiscounts().isEmpty());
    }

    @Test
    public void discountsPopulated() {
        this.basket.addItem(new Apples());
        Map<Item, Double> discounts = this.basket.getDiscounts();
        Assert.assertEquals(1, discounts.size());
        Assert.assertEquals(0.1, discounts.get(new Apples()), 0);
    }

    @Test
    public void discountsAccumulated() {
        this.basket.addItem(new Apples());
        this.basket.addItem(new Apples());
        Map<Item, Double> discounts = this.basket.getDiscounts();
        Assert.assertEquals(1, discounts.size());
        Assert.assertEquals(0.2, discounts.get(new Apples()), 0);
    }

    @Test
    public void discountsSeparated() {
        Item bananas = new Item("Bananas", 1, 20) {
        };
        this.basket.addItem(new Apples());
        this.basket.addItem(bananas);
        Map<Item, Double> discounts = this.basket.getDiscounts();
        Assert.assertEquals(2, discounts.size());
        Assert.assertEquals(0.1, discounts.get(new Apples()), 0);
        Assert.assertEquals(0.2, discounts.get(bananas), 0);
    }

    @Test
    public void subtotalLine() {
        Assert.assertEquals("Subtotal: £2.10", this.basket.getSubtotalLine());
    }

    @Test
    public void totalLine() {
        Assert.assertEquals("Total: £2.10", this.basket.getTotalLine());
    }

    @Test
    public void discountLinesWithNoDiscountedItems() {
        List<String> discountLines = this.basket.getDiscountLines();
        Assert.assertEquals(1, discountLines.size());
        Assert.assertEquals("(No offers available)", discountLines.get(0));
    }

    @Test
    public void discountLinesWithDiscountedItem() {
        this.basket.addItem(new Apples());
        List<String> discountLines = this.basket.getDiscountLines();
        Assert.assertEquals(1, discountLines.size());
        Assert.assertEquals("Apples 10% off: -10p", discountLines.get(0));
    }

    @Test
    public void discountLinesWithRepeatedDiscountedItems() {
        this.basket.addItem(new Apples());
        this.basket.addItem(new Apples());
        List<String> discountLines = this.basket.getDiscountLines();
        Assert.assertEquals(1, discountLines.size());
        Assert.assertEquals("Apples 10% off: -20p", discountLines.get(0));
    }

    @Test
    public void discountLinesWithDifferentDiscountedItems() {
        this.basket.addItem(new Apples());
        this.basket.addItem(new Item("Candies", 10, 10){});
        List<String> discountLines = this.basket.getDiscountLines();
        Assert.assertEquals(2, discountLines.size());
        Assert.assertTrue(discountLines.contains("Apples 10% off: -10p"));
        Assert.assertTrue(discountLines.contains("Candies 10% off: £-1.00"));
    }
}
