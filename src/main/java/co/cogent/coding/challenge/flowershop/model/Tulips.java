package co.cogent.coding.challenge.flowershop.model;

import co.cogent.coding.challenge.flowershop.service.Packaging;
import co.cogent.coding.challenge.flowershop.service.impl.TulipsBundle;
import co.cogent.coding.challenge.flowershop.service.impl.TulipsBundle.TulipsBundleSizes;

/**
 * Class for Tulips Flower
 * 
 * @author val
 *
 */
public class Tulips extends Flower {

    private static final ProductCodeEnum CODE = ProductCodeEnum.TULIPS;

    private TulipsBundle bundle;

    private int orderedPieces;

    public Tulips(final int orderedPieces) {
	super();
	this.orderedPieces = orderedPieces;
	bundle = new TulipsBundle(orderedPieces);
    }

    @Override
    public String name() {
	return ProductCodeEnum.TULIPS.toString();
    }

    @Override
    public ProductCodeEnum code() {
	return CODE;
    }

    /**
     * Returns the packaging type
     */
    @Override
    public Packaging packaging() {
	return bundle;
    }

    public int getOrderedPieces() {
	return orderedPieces;
    }

    public void setOrderedPieces(final int orderedPieces) {
	this.orderedPieces = orderedPieces;
    }

    /**
     * Method that calculates the price of Ordered Tulips per bundles
     */
    @Override
    public double price() {
	double totalPrice = 0;
	Integer count = 0;

	for (TulipsBundleSizes bundleSize : TulipsBundleSizes.values()) {
	    count = bundle.getTulipsBundleMap().get(bundleSize);
	    if (count != null) {
		totalPrice += count * bundleSize.price;
	    }
	}

	return totalPrice;
    }

    /**
     * Method that shows the details of Ordered Tulips per bundles
     */
    @Override
    public void showDetails() {
	Integer count = 0;
	for (TulipsBundleSizes bundleSize : TulipsBundleSizes.values()) {
	    count = bundle.getTulipsBundleMap().get(bundleSize);
	    if (count != null) {
		System.out.println("	  " + count + " x " + bundleSize.value
			+ " $" + bundleSize.price);
	    }
	}
    }
}
