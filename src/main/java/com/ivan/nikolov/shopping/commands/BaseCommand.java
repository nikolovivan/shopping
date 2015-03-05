/**
 *
 */
package com.ivan.nikolov.shopping.commands;

import com.ivan.nikolov.shopping.exceptions.CommandErrorException;


/**
 * @author inikolov
 *
 */
public abstract class BaseCommand {

    private final String name;
    protected final String[] arguments;

    public BaseCommand(final String name, final String[] arguments) {
        this.name = name;
        this.arguments = arguments;
    }

    /**
     * @return the name
     */
    public String getName() {
        return this.name;
    }

    /**
     * @return the arguments
     */
    public String[] getArguments() {
        return this.arguments;
    }

    /**
     * The execute method of a command. We can have different commands and
     * each will implement this method. We could also have different return
     * types for execute with generics, but it's not necessary for the current
     * case.
     *
     * @throws CommandErrorException
     */
    public abstract void execute() throws CommandErrorException;
}
