package org.coding.challenge.flowershop.service;

import junit.framework.Assert;

import org.coding.challenge.flowershop.service.impl.TulipsBundle;
import org.coding.challenge.flowershop.service.impl.TulipsBundle.TulipsBundleSizes;
import org.junit.Before;
import org.junit.Test;

public class TulipsBundleTest {

    private TulipsBundle bundle = new TulipsBundle(10);

    @Before
    public void before() throws Exception {
	bundle = new TulipsBundle(16);
    }

    @Test
    public void testPack() {
	bundle.pack();
	bundle = new TulipsBundle(10);
	bundle.pack();
	bundle.setOrderedPieces(14);
	bundle.pack();
	Assert.assertEquals(1,
		bundle.getTulipsBundleMap().get(TulipsBundleSizes.NINE)
			.intValue());
	Assert.assertEquals(1,
		bundle.getTulipsBundleMap().get(TulipsBundleSizes.FIVE)
			.intValue());
	Assert.assertEquals(14, bundle.getOrderedPieces());

	bundle.pack();
    }

}
