/**
 *
 */
package com.ivan.nikolov.shopping.factory;

import com.ivan.nikolov.shopping.exceptions.UnknownItemExeption;
import com.ivan.nikolov.shopping.model.Apples;
import com.ivan.nikolov.shopping.model.Bread;
import com.ivan.nikolov.shopping.model.Item;
import com.ivan.nikolov.shopping.model.Milk;
import com.ivan.nikolov.shopping.model.Soup;


/**
 * @author inikolov
 *
 */
public final class ItemsFactory {

    /**
     * Just because we don't want to instantiate this class.
     * At least for now.
     */
    private ItemsFactory() {

    }

    public static Item getItem(final String name) throws UnknownItemExeption {
        switch (name.toUpperCase()) {
        case "APPLES":
            return new Apples();
        case "BREAD":
            return new Bread();
        case "MILK":
            return new Milk();
        case "SOUP":
            return new Soup();
        default:
            throw new UnknownItemExeption(String.format("The item with name %s is unknown.", name));
        }
    }
}
