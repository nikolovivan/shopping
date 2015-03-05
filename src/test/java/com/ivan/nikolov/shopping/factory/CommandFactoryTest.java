/**
 *
 */
package com.ivan.nikolov.shopping.factory;

import org.junit.Assert;
import org.junit.Test;

import com.ivan.nikolov.shopping.commands.BaseCommand;
import com.ivan.nikolov.shopping.exceptions.InvalidCommandException;


/**
 * @author inikolov
 *
 */
public class CommandFactoryTest {

    @Test(expected = InvalidCommandException.class)
    public void noArgumentsSupplied() throws InvalidCommandException {
        CommandFactory.getCommand(new String[0]);
    }

    @Test(expected = InvalidCommandException.class)
    public void unknownCommand() throws InvalidCommandException {
        CommandFactory.getCommand(new String[]{ "Unknown" });
    }

    @Test(expected = InvalidCommandException.class)
    public void wrongCaseCommand() throws InvalidCommandException {
        CommandFactory.getCommand(new String[]{ "pricebasket" });
    }

    @Test
    public void correctCommandName() throws InvalidCommandException {
        Assert.assertNotNull(CommandFactory.getCommand(new String[]{ "PriceBasket" }));
    }

    @Test
    public void correctParameterAssignment() throws InvalidCommandException {
        BaseCommand command = CommandFactory.getCommand(new String[]{ "PriceBasket", "Item1", "Item2" });
        Assert.assertEquals(2, command.getArguments().length);
        Assert.assertEquals("Item1", command.getArguments()[0]);
        Assert.assertEquals("Item2", command.getArguments()[1]);
    }
}
