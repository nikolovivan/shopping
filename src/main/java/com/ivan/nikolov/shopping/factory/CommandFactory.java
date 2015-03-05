/**
 *
 */
package com.ivan.nikolov.shopping.factory;

import java.util.Arrays;

import com.ivan.nikolov.shopping.commands.BaseCommand;
import com.ivan.nikolov.shopping.commands.PriceBasketCommand;
import com.ivan.nikolov.shopping.exceptions.InvalidCommandException;


/**
 * @author inikolov
 *
 */
public final class CommandFactory {

    private CommandFactory() {

    }

    public static BaseCommand getCommand(final String[] arguments) throws InvalidCommandException {
        if (arguments == null || arguments.length == 0) {
            throw new InvalidCommandException("A command must be specified!");
        }
        String commandName = CommandFactory.getCommandName(arguments);
        String[] commandArguments = CommandFactory.getCommandArguments(arguments);
        switch(commandName) {
        case "PriceBasket":
            return new PriceBasketCommand(commandArguments);
        default:
            throw new InvalidCommandException(String.format("The command %s is unknown! Please mind that this is case sensitive.", arguments[0]));
        }
    }

    /**
     * Gets just the first item, which is the command name.
     *
     * @param arguments
     * @return
     */
    private static String getCommandName(final String[] arguments) {
        return arguments[0];
    }

    /**
     * Gets all arguments except the first one, which is the command name.
     *
     * @param arguments
     * @return
     */
    private static String[] getCommandArguments(final String[] arguments) {
        return arguments.length <= 1 ? new String[0] : Arrays.copyOfRange(arguments, 1, arguments.length);
    }
}
