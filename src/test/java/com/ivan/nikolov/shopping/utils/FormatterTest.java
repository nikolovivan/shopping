/**
 *
 */
package com.ivan.nikolov.shopping.utils;

import org.junit.Assert;
import org.junit.Test;


/**
 * @author inikolov
 *
 */
public class FormatterTest {

    @Test
    public void gettingPricesLessThanAFullPound() {
        Assert.assertEquals("10p", Formatter.numberToCurrencyString(0.10));
        Assert.assertEquals("-10p", Formatter.numberToCurrencyString(-0.10));
    }

    @Test
    public void roundingPricesInPence() {
        Assert.assertEquals("57p", Formatter.numberToCurrencyString(0.567));
        Assert.assertEquals("56p", Formatter.numberToCurrencyString(0.564));
    }

    @Test
    public void gettingNumbersMoreThanOnePound() {
        Assert.assertEquals("£6.57", Formatter.numberToCurrencyString(6.567));
    }

    @Test
    public void gettingNegativeNumbers() {
        Assert.assertEquals("£-9.10", Formatter.numberToCurrencyString(-9.10));
    }
}
