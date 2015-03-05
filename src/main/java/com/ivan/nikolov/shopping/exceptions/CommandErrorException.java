/**
 *
 */
package com.ivan.nikolov.shopping.exceptions;


/**
 * @author inikolov
 *
 */
public class CommandErrorException extends Exception {

    /**
     *
     */
    private static final long serialVersionUID = -7961753177040015898L;

    public CommandErrorException(final String message, final Throwable ex) {
        super(message, ex);
    }

}
