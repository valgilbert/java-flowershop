package org.coding.challenge.flowershop.service.impl;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * Class implementation for Bundle Packaging of Lilies
 * 
 * @author val
 *
 */
public class LiliesBundle extends Bundle {

    private Map<LiliesBundleSizes, Integer> liliesBundleMap;

    private int orderedPieces;

    public enum LiliesBundleSizes {
	NINE(9, 24.95), SIX(6, 16.95), THREE(3, 9.95), ;// must be in descending
							// order

	public int value;

	public double price;

	private LiliesBundleSizes(int value, double price) {
	    this.value = value;
	    this.price = price;
	}
    };

    public LiliesBundle(final int orderedPieces) {
	super();
	this.orderedPieces = orderedPieces;
	liliesBundleMap = new HashMap<LiliesBundleSizes, Integer>();
    }

    public Map<LiliesBundleSizes, Integer> getLiliesBundleMap() {
	return liliesBundleMap;
    }

    public int getOrderedPieces() {
	return orderedPieces;
    }

    public void setOrderedPieces(final int orderedPieces) {
	this.orderedPieces = orderedPieces;
    }

    /**
     * Method Implementation for bundling Lilies
     */
    @Override
    public int pack() {
	int nPieces = orderedPieces;

	int i = 0;
	while (nPieces > 0 && i < LiliesBundleSizes.values().length) {
	    nPieces = this.packHelper(orderedPieces, Arrays.copyOfRange(
		    LiliesBundleSizes.values(), i,
		    LiliesBundleSizes.values().length));

	    if (nPieces > 0 && i < LiliesBundleSizes.values().length) {
		liliesBundleMap.clear();
	    }

	    i++;
	}

	return nPieces;
    }

    /**
     * Method helper for bundling Lilies
     */
    private int packHelper(final int pieces, final LiliesBundleSizes[] sizeRange) {
	int nPieces = pieces;
	int remainder = 0;
	int nBundles = 0;

	for (int j = 0; j < sizeRange.length; j++) {
	    if (nPieces > 0 && nPieces >= sizeRange[j].value) {
		remainder = nPieces % sizeRange[j].value;
		nBundles = (nPieces - remainder) / sizeRange[j].value;
		nPieces = nPieces - (nBundles * sizeRange[j].value);
		liliesBundleMap.put(sizeRange[j], nBundles);
	    }
	}

	return nPieces;
    }

}
