/**
 *
 */
package com.ivan.nikolov.shopping.exceptions;


/**
 * @author inikolov
 *
 */
public class UnknownItemExeption extends Exception {

    /**
     *
     */
    private static final long serialVersionUID = -2355349383331731118L;

    public UnknownItemExeption() {
        super();
    }

    public UnknownItemExeption(final String message) {
        super(message);
    }

    public UnknownItemExeption(final String message, final Throwable ex) {
        super(message, ex);
    }

}
