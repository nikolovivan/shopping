/**
 *
 */
package com.ivan.nikolov.shopping.model;

import org.junit.Assert;
import org.junit.Test;

/**
 * @author inikolov
 *
 */
public class ItemTest {

    // no neeed to test getters...

    @Test
    public void gettingNonDiscountedItemFinalPrice() {
        Bread bread = new Bread();
        Assert.assertEquals(bread.getPrice(), bread.getFinalPrice(), 0);
    }

    @Test
    public void gettingNonDiscountedItemDiscount() {
        Milk milk = new Milk();
        Assert.assertEquals(0, milk.getDiscountedAmount(), 0);
    }

    @Test
    public void gettingDiscountedItemFinalPrice() {
        Apples apples = new Apples();
        Assert.assertEquals(0.9, apples.getFinalPrice(), 0);
    }

    @Test
    public void gettingDiscountedItemDiscount() {
        Apples apples = new Apples();
        Assert.assertEquals(0.1, apples.getDiscountedAmount(), 0);
    }

    @Test
    public void gettingNegativeDiscountsShouldIncreaseThePrice() {
        Item item = new Item("test", 10, -10) {
        };
        Assert.assertEquals(11.0, item.getFinalPrice(), 0);
    }

    @Test
    public void gettingNegativeDictountsShouldReturnTheDiscountedAmountAsNegative() {
        Item item = new Item("test", 10, -10) {
        };
        Assert.assertEquals(-1, item.getDiscountedAmount(), 0);
    }
}
