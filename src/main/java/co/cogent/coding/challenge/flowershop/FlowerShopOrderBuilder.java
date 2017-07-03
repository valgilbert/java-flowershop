package co.cogent.coding.challenge.flowershop;

import co.cogent.coding.challenge.flowershop.model.FlowerShopOrder;
import co.cogent.coding.challenge.flowershop.model.Lilies;
import co.cogent.coding.challenge.flowershop.model.ProductCodeEnum;
import co.cogent.coding.challenge.flowershop.model.Roses;
import co.cogent.coding.challenge.flowershop.model.Tulips;

/**
 * Builder Class for FlowerShop Orders
 * 
 * @author val
 *
 */
public class FlowerShopOrderBuilder {

    private FlowerShopOrder order = new FlowerShopOrder();

    public FlowerShopOrder getOrder() {
	return order;
    }

    public void setOrder(final FlowerShopOrder order) {
	this.order = order;
    }

    /**
     * Add Item to Order
     * 
     * @param orderedPieces
     * @param code
     * @return order
     */
    public FlowerShopOrder addItemToCart(final int orderedPieces,
	    final ProductCodeEnum code) {

	switch (code) {
	case ROSES:
	    order.addFlowerShopItem(new Roses(orderedPieces));
	    break;
	case LILIES:
	    order.addFlowerShopItem(new Lilies(orderedPieces));
	    break;
	case TULIPS:
	    order.addFlowerShopItem(new Tulips(orderedPieces));
	    break;
	}

	return order;
    }
}
