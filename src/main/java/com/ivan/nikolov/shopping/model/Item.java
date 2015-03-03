/**
 *
 */
package com.ivan.nikolov.shopping.model;

/**
 * A base class for all items.
 *
 * @author inikolov
 *
 */
public abstract class Item {

    private final String name;
    private final double price;
    private final double discount;

    /**
     *
     * @param name
     *            The name of the item.
     * @param price
     *            The normal price.
     * @param discount
     *            The discount as a percentage. Positive to lower the price,
     *            negative to increase it.
     */
    public Item(final String name, final double price, final double discount) {
        this.name = name;
        this.price = price;
        this.discount = discount;
    }

    /**
     * @return the name
     */
    public String getName() {
        return this.name;
    }

    /**
     * @return the price
     */
    public double getPrice() {
        return this.price;
    }

    /**
     * @return the discount
     */
    public double getDiscount() {
        return this.discount;
    }

    /**
     * @return the final price after the discount has been applied.
     */
    public double getFinalPrice() {
        return (1 - this.discount / 100) * this.price;
    }

    /**
     *
     * @return only the amount that is discounted from this item.
     */
    public double getDiscountedAmount() {
        return this.discount / 100 * this.price;
    }
}
