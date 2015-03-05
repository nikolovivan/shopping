/**
 *
 */
package com.ivan.nikolov.shopping.commands;

import com.ivan.nikolov.shopping.exceptions.CommandErrorException;
import com.ivan.nikolov.shopping.exceptions.UnknownItemExeption;
import com.ivan.nikolov.shopping.factory.ItemsFactory;
import com.ivan.nikolov.shopping.model.Basket;


/**
 * @author inikolov
 *
 */
public class PriceBasketCommand extends BaseCommand {

    /**
     * @param name
     */
    public PriceBasketCommand(final String[] arguments) {
        super("PriceBasket", arguments);
    }

    /* (non-Javadoc)
     * @see com.ivan.nikolov.shopping.commands.BaseCommand#execute()
     */
    @Override
    public void execute() throws CommandErrorException {
        try {
            Basket basket = new Basket();
            for (String item : this.arguments) {
                basket.addItem(ItemsFactory.getItem(item));
            }
            System.out.println(basket.print());
        } catch (UnknownItemExeption e) {
            throw new CommandErrorException(e.getMessage(), e);
        }
    }
}
