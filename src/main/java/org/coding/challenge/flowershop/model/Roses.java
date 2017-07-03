package org.coding.challenge.flowershop.model;

import org.coding.challenge.flowershop.service.Packaging;
import org.coding.challenge.flowershop.service.impl.RosesBundle;
import org.coding.challenge.flowershop.service.impl.RosesBundle.RosesBundleSizes;

/**
 * Class for Roses Flower
 * 
 * @author val
 *
 */
public class Roses extends Flower {

    private static final ProductCodeEnum CODE = ProductCodeEnum.ROSES;

    private RosesBundle bundle;

    private int orderedPieces;

    public Roses(final int orderedPieces) {
	super();
	this.orderedPieces = orderedPieces;
	bundle = new RosesBundle(orderedPieces);
    }

    @Override
    public String name() {
	return ProductCodeEnum.ROSES.toString();
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
     * Returns the price of Ordered Roses per bundles
     */
    @Override
    public double price() {
	double totalPrice = 0;
	Integer count = 0;

	for (RosesBundleSizes bundleSize : RosesBundleSizes.values()) {
	    count = bundle.getRosesBundleMap().get(bundleSize);
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
	for (RosesBundleSizes bundleSize : RosesBundleSizes.values()) {
	    count = bundle.getRosesBundleMap().get(bundleSize);
	    if (count != null) {
		System.out.println("	  " + count + " x " + bundleSize.value
			+ " $" + bundleSize.price);
	    }
	}
    }
}
