package com.ivan.nikolov.shopping;

import com.ivan.nikolov.shopping.commands.BaseCommand;
import com.ivan.nikolov.shopping.exceptions.CommandErrorException;
import com.ivan.nikolov.shopping.exceptions.InvalidCommandException;
import com.ivan.nikolov.shopping.factory.CommandFactory;

/**
 * The application itself.
 *
 */
public class App {
    public static void main( final String[] args ) {
        try {
            BaseCommand command = CommandFactory.getCommand(args);
            command.execute();
        } catch (InvalidCommandException | CommandErrorException e) {
            System.err.println(e.getMessage());
            System.exit(-1);
        }
    }
}
