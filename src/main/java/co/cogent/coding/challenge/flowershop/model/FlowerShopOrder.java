package co.cogent.coding.challenge.flowershop.model;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

/**
 * Class for FlowerShopOrder
 * 
 * @author val
 *
 */
public class FlowerShopOrder {

    private List<FlowerShopItem> items = new ArrayList<FlowerShopItem>();

    public List<FlowerShopItem> getItems() {
	return items;
    }

    public void setItems(final List<FlowerShopItem> items) {
	this.items = items;
    }

    public void addFlowerShopItem(final FlowerShopItem item) {
	items.add(item);
    }

    /**
     * Method to show the Details of the Ordered Items
     */
    public void showItems() {
	int nRemainingItems = 0;
	final DecimalFormat df = new DecimalFormat("#.##");

	for (FlowerShopItem item : items) {
	    System.out.print(item.getOrderedPieces());
	    System.out.print(" [" + item.name() + "]");
	    System.out.print(", [" + item.code().getValue() + "]");
	    nRemainingItems = item.packaging().pack();
	    System.out.println(", Remaining items after packed ["
		    + nRemainingItems + "]");
	    if (nRemainingItems > 0) {
		System.out
			.println(", Unable to pack ordered items. Please Order in correct bundles.");
	    }
	    System.out.println("Total Price [" + df.format(item.price()) + "]");
	    item.showDetails();
	}

	// clear items afterwards
	items.clear();
    }
}
