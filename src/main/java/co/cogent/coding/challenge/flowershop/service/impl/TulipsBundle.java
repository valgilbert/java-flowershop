package co.cogent.coding.challenge.flowershop.service.impl;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * Class implementation for Bundle Packaging of Tulips
 * 
 * @author val
 *
 */
public class TulipsBundle extends Bundle {

    private HashMap<TulipsBundleSizes, Integer> tulipsBundleMap;

    private int orderedPieces;

    public enum TulipsBundleSizes {
	NINE(9, 16.99), FIVE(5, 9.95), THREE(3, 5.95), ;// must be in descending
							// order

	public int value;

	public double price;

	private TulipsBundleSizes(final int value, final double price) {
	    this.value = value;
	    this.price = price;
	}
    };

    public TulipsBundle(final int orderedPieces) {
	super();
	this.orderedPieces = orderedPieces;
	tulipsBundleMap = new HashMap<TulipsBundleSizes, Integer>();
    }

    public Map<TulipsBundleSizes, Integer> getTulipsBundleMap() {
	return tulipsBundleMap;
    }

    public int getOrderedPieces() {
	return orderedPieces;
    }

    public void setOrderedPieces(final int orderedPieces) {
	this.orderedPieces = orderedPieces;
    }

    /**
     * Method Implementation for bundling Tulips
     */
    @Override
    public int pack() {
	int nPieces = orderedPieces;

	int i = 0;
	while (nPieces > 0 && i < TulipsBundleSizes.values().length) {
	    nPieces = this.packHelper(orderedPieces, Arrays.copyOfRange(
		    TulipsBundleSizes.values(), i,
		    TulipsBundleSizes.values().length));

	    if (nPieces > 0 && i < TulipsBundleSizes.values().length) {
		tulipsBundleMap.clear();
	    }

	    i++;
	}

	return nPieces;
    }

    /**
     * Method helper for bundling Tulips
     */
    private int packHelper(final int pieces, final TulipsBundleSizes[] sizeRange) {
	int nPieces = pieces;
	int remainder = 0;
	int nBundles = 0;

	for (int j = 0; j < sizeRange.length; j++) {
	    if (nPieces > 0 && nPieces >= sizeRange[j].value) {
		remainder = nPieces % sizeRange[j].value;
		nBundles = (nPieces - remainder) / sizeRange[j].value;
		nPieces = nPieces - (nBundles * sizeRange[j].value);
		tulipsBundleMap.put(sizeRange[j], nBundles);
	    }
	}

	return nPieces;
    }

}
