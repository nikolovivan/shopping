/**
 *
 */
package com.ivan.nikolov.shopping.utils;


/**
 * @author inikolov
 *
 */
public final class Formatter {

    /**
     * Util class. No need to instantiate.
     */
    private Formatter() {

    }

    /**
     * Writes the given number in the right format. The currency is
     * set to GBP, but can be easily extended and provided as a parameter.
     *
     * @param number
     * @return
     */
    public static String numberToCurrencyString(final double number) {
        return Math.abs(number) < 1.0 ? String.format("%dp", Math.round(number * 100)) : String.format("£%.2f", number);
    }
}
