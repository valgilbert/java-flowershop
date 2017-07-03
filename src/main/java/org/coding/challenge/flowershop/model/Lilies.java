package org.coding.challenge.flowershop.model;

import org.coding.challenge.flowershop.service.Packaging;
import org.coding.challenge.flowershop.service.impl.LiliesBundle;
import org.coding.challenge.flowershop.service.impl.LiliesBundle.LiliesBundleSizes;

/**
 * Class for Lilies Flower
 * 
 * @author val
 *
 */
public class Lilies extends Flower {

    private static final ProductCodeEnum CODE = ProductCodeEnum.LILIES;

    private LiliesBundle bundle;

    private int orderedPieces;

    public Lilies(final int orderedPieces) {
	super();
	this.orderedPieces = orderedPieces;
	bundle = new LiliesBundle(orderedPieces);
    }

    @Override
    public String name() {
	return ProductCodeEnum.LILIES.toString();
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
     * Returns the price of Ordered Lilies per bundles
     */
    @Override
    public double price() {
	double totalPrice = 0;
	Integer count = 0;

	for (LiliesBundleSizes bundleSize : LiliesBundleSizes.values()) {
	    count = bundle.getLiliesBundleMap().get(bundleSize);
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
	for (LiliesBundleSizes bundleSize : LiliesBundleSizes.values()) {
	    count = bundle.getLiliesBundleMap().get(bundleSize);
	    if (count != null) {
		System.out.println("	  " + count + " x " + bundleSize.value
			+ " $" + bundleSize.price);
	    }
	}
    }

}
