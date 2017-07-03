package org.coding.challenge.flowershop.service.impl;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * Class implementation for Bundle Packaging of Roses
 * 
 * @author val
 *
 */
public class RosesBundle extends Bundle {

    private Map<RosesBundleSizes, Integer> rosesBundleMap;

    private int orderedPieces;

    public enum RosesBundleSizes {
	TEN(10, 12.99), FIVE(5, 6.99), ;// must be in descending order

	public int value;

	public double price;

	private RosesBundleSizes(int value, double price) {
	    this.value = value;
	    this.price = price;
	}
    };

    public RosesBundle(int orderedPieces) {
	super();
	this.orderedPieces = orderedPieces;
	rosesBundleMap = new HashMap<RosesBundleSizes, Integer>();
    }

    public Map<RosesBundleSizes, Integer> getRosesBundleMap() {
	return rosesBundleMap;
    }

    public int getOrderedPieces() {
	return orderedPieces;
    }

    public void setOrderedPieces(int orderedPieces) {
	this.orderedPieces = orderedPieces;
    }

    /**
     * Method Implementation for bundling Roses
     */
    @Override
    public int pack() {
	int nPieces = orderedPieces;

	int i = 0;
	while (nPieces > 0 && i < RosesBundleSizes.values().length) {
	    nPieces = this.packHelper(orderedPieces, Arrays.copyOfRange(
		    RosesBundleSizes.values(), i,
		    RosesBundleSizes.values().length));

	    if (nPieces > 0 && i < RosesBundleSizes.values().length) {
		rosesBundleMap.clear();
	    }

	    i++;
	}

	return nPieces;
    }

    /**
     * Method helper for bundling Roses
     */
    private int packHelper(final int pieces, final RosesBundleSizes[] sizeRange) {
	int nPieces = pieces;
	int remainder = 0;
	int nBundles = 0;

	for (int j = 0; j < sizeRange.length; j++) {
	    if (nPieces > 0 && nPieces >= sizeRange[j].value) {
		remainder = nPieces % sizeRange[j].value;
		nBundles = (nPieces - remainder) / sizeRange[j].value;
		nPieces = nPieces - (nBundles * sizeRange[j].value);
		rosesBundleMap.put(sizeRange[j], nBundles);
	    }
	}

	return nPieces;
    }

}
