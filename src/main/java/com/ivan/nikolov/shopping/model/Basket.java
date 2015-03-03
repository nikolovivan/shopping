/**
 *
 */
package com.ivan.nikolov.shopping.model;

import java.util.ArrayList;
import java.util.List;


/**
 * @author inikolov
 *
 */
public class Basket {

    private final List<Item> items;

    public Basket() {
        this.items = new ArrayList<>();
    }

    public Basket(final List<Item> items) {
        this.items = items;
    }

    /**
     * @param item
     */
    public void addItem(final Item item) {
        this.items.add(item);
    }

    /**
     * Removes an item at a specific index.
     *
     * @param index
     */
    public void removeItem(final int index) {
        this.items.remove(index);
    }

    /**
     * Gets the subtotal without applying any discounts.
     *
     * @return
     */
    public double getSubtotal() {
        double sum = 0.0;
        for (Item item : this.items) {
            sum += item.getPrice();
        }
        return sum;
    }

    /**
     * Gets the actual total by applying discounts.
     *
     * @return
     */
    public double getTotal() {
        double sum = 0.0;
        for (Item item : this.items) {
            sum += item.getFinalPrice();
        }
        return sum;
    }

    /**
     * Prints the basket string.
     *
     * @return
     */
    public String print() {
        StringBuilder builder = new StringBuilder();
        return builder.toString();
    }

    /* (non-Javadoc)
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
        return this.print();
    }


}
