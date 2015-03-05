/**
 *
 */
package com.ivan.nikolov.shopping.exceptions;


/**
 * @author inikolov
 *
 */
public class InvalidCommandException extends Exception {

    /**
     *
     */
    private static final long serialVersionUID = 5555089359302048028L;

    public InvalidCommandException() {
        super();
    }

    public InvalidCommandException(final String message) {
        super(message);
    }

}
