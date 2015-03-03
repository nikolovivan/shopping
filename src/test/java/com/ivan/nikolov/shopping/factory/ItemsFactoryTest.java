/**
 *
 */
package com.ivan.nikolov.shopping.factory;

import org.hamcrest.CoreMatchers;
import org.junit.Assert;
import org.junit.Test;

import com.ivan.nikolov.shopping.exceptions.UnknownItemExeption;
import com.ivan.nikolov.shopping.model.Apples;
import com.ivan.nikolov.shopping.model.Bread;
import com.ivan.nikolov.shopping.model.Milk;
import com.ivan.nikolov.shopping.model.Soup;


/**
 * @author inikolov
 *
 */
public class ItemsFactoryTest {

    @Test
    public void gettingKnownItemsWithVaryingCases() throws UnknownItemExeption {
        Assert.assertThat(ItemsFactory.getItem("Apples"), CoreMatchers.instanceOf(Apples.class));
        Assert.assertThat(ItemsFactory.getItem("bread"), CoreMatchers.instanceOf(Bread.class));
        Assert.assertThat(ItemsFactory.getItem("MiLk"), CoreMatchers.instanceOf(Milk.class));
        Assert.assertThat(ItemsFactory.getItem("SOUP"), CoreMatchers.instanceOf(Soup.class));
    }

    @Test(expected = UnknownItemExeption.class)
    public void gettingUnknownItemsShouldFail() throws UnknownItemExeption {
        ItemsFactory.getItem("Carrots");
    }
}
