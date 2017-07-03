package org.coding.challenge.flowershop.model;

import java.util.ArrayList;
import java.util.List;

import org.coding.challenge.flowershop.model.Flower;
import org.coding.challenge.flowershop.model.FlowerShopItem;
import org.coding.challenge.flowershop.model.FlowerShopOrder;
import org.coding.challenge.flowershop.model.Lilies;
import org.coding.challenge.flowershop.model.Roses;
import org.junit.Before;
import org.junit.Test;

public class FlowerShopOrderTest {

    private FlowerShopOrder order = new FlowerShopOrder();

    @Before
    public void before() throws Exception {
    }

    @Test
    public void testAddFlowerShopItem() {
	Flower item = new Roses(10);
	order.addFlowerShopItem(item);

	

    }

    @Test
    public void testShowItems() {
	List<FlowerShopItem> items = new ArrayList<FlowerShopItem>();
	items.add(new Roses(15));
	items.add(new Lilies(15));
	order.setItems(items);
	order.showItems();
    }
}
