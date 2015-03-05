/**
 *
 */
package com.ivan.nikolov.shopping.commands;

import org.junit.Assert;
import org.junit.Test;

import com.ivan.nikolov.shopping.exceptions.CommandErrorException;


/**
 * @author inikolov
 *
 */
public class PriceBasketCommandTest {

    @Test(expected = CommandErrorException.class)
    public void unknownItemsInBasket() throws CommandErrorException {
        PriceBasketCommand priceBasketCommand = new PriceBasketCommand(new String[] {"apples", "Bananas"});
        priceBasketCommand.execute();
    }

    @Test
    public void noItemsInBasket() {
        try {
            PriceBasketCommand priceBasketCommand = new PriceBasketCommand(new String[0]);
            priceBasketCommand.execute();
        } catch (CommandErrorException e) {
            Assert.fail("An exception was thrown when it shouldn't have.");
        }
    }

    @Test
    public void knownItemsInBasket() {
        try {
            PriceBasketCommand priceBasketCommand = new PriceBasketCommand(new String[] { "Apples", "Soup", "Apples", "Milk" });
            priceBasketCommand.execute();
        } catch (CommandErrorException e) {
            Assert.fail("An exception was thrown when it shouldn't have.");
        }
    }
}
