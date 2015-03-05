/**
 *
 */
package com.ivan.nikolov.shopping.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import com.ivan.nikolov.shopping.utils.Constants;
import com.ivan.nikolov.shopping.utils.Formatter;


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
     * @return the items
     */
    public List<Item> getItems() {
        return this.items;
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
    public Item removeItem(final int index) {
        return this.items.remove(index);
    }

    /**
     * Removes a specific item.
     *
     * @param item
     */
    public boolean removeItem(final Item item) {
        return this.items.remove(item);
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
     * Gets the discounts grouped by the item. The reason
     * to have this is that sometimes we might get multiple
     * products and their total discounted price should accumulate. Also
     * discounts are possible on more than one item.
     *
     * There is no specific ordering due to the map...
     *
     * @return
     */
    public Map<Item, Double> getDiscounts() {
        Map<Item, Double> result = new HashMap<>();
        for (Item item : this.items) {
            if (item.isDiscounted()) {
                Double sum = result.get(item);
                result.put(item, sum != null ? sum + item.getDiscountedAmount() : item.getDiscountedAmount());
            }
        }
        return result;
    }

    /**
     * Prints the basket string.
     *
     * @return
     */
    public String print() {
        if (this.items.isEmpty()) {
            return "The basket is empty.";
        }
        StringBuilder builder = new StringBuilder();
        builder.append(this.getSubtotalLine()).append(Constants.NEW_LINE);
        for (String line : this.getDiscountLines()) {
            builder.append(line).append(Constants.NEW_LINE);
        }
        builder.append(this.getTotalLine()).append(Constants.NEW_LINE);
        return builder.toString();
    }


    public String getSubtotalLine() {
        return String.format("Subtotal: %s", Formatter.numberToCurrencyString(this.getSubtotal()));
    }

    public String getTotalLine() {
        // By the way - this line looks differently when there is a discount and when there isn't.
        // I am assuming this was by mistake as it doesn't make too much sense, so it will look like this all the time.
        return String.format("Total: %s", Formatter.numberToCurrencyString(this.getTotal()));
    }

    public List<String> getDiscountLines() {
        Map<Item, Double> discounts = this.getDiscounts();
        List<String> result = new ArrayList<>();
        if (discounts.isEmpty()) {
            result.add("(No offers available)");
        } else {
            for (Entry<Item, Double> discountItem : discounts.entrySet()) {
                Item item = discountItem.getKey();
                double amount = discountItem.getValue();
                result.add(
                        String.format(
                                "%s %d%% off: %s",
                                item.getName(),
                                Math.round(item.getDiscount()),
                                Formatter.numberToCurrencyString(-amount)
                                )
                        );
            }
        }
        return result;
    }

    /* (non-Javadoc)
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
        return this.print();
    }


}
