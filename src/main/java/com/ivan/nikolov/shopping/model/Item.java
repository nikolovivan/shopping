/**
 *
 */
package com.ivan.nikolov.shopping.model;

import com.google.common.base.Objects;
import com.google.common.base.Strings;

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
     * These are attributes that each basket item can have. Then it's up
     * to the items to set them when they get instantiated. No need for
     * more exotic design patterns.
     *
     * @param name
     *            The name of the item.
     * @param price
     *            The normal price.
     * @param discount
     *            The discount as a percentage. Positive only.
     */
    public Item(final String name, final double price, final double discount) {
        this.validate(name, price, discount);
        this.name = name;
        this.price = price;
        this.discount = discount;
    }

    /**
     * Validates the parameters supplied to the function
     * are properly set up.
     *
     * @param name
     * @param price
     * @param discount
     */
    private void validate(final String name, final double price, final double discount) {
        if (Strings.isNullOrEmpty(name)) {
            throw new IllegalArgumentException("A non-empty name must be specified.");
        }
        if (price < 0.0) {
            throw new IllegalArgumentException("The price cannot be negative.");
        }
        if (discount < 0.0 || discount > 100.0) {
            throw new IllegalArgumentException("The discount must be a non-negative number not greater than 100.");
        }
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
     * @return whether there is a discount (or a price modification) on the item.
     */
    public boolean isDiscounted() {
        return this.discount != 0.0;
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

    /* (non-Javadoc)
     * @see java.lang.Object#hashCode()
     */
    @Override
    public int hashCode() {
        // just making sure that the name doesn't depend on the case.
        return Objects.hashCode(this.name.toUpperCase(), this.price, this.discount);
    }

    /* (non-Javadoc)
     * @see java.lang.Object#equals(java.lang.Object)
     */
    @Override
    public boolean equals(final Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (!(obj instanceof Item)) {
            return false;
        }
        Item other = (Item)obj;
        return Objects.equal(this.name, other.name) &&
                Objects.equal(this.price, other.price) &&
                Objects.equal(this.discount, other.discount);
    }
}
