package org.coding.challenge.flowershop.service;

import junit.framework.Assert;

import org.coding.challenge.flowershop.service.impl.LiliesBundle;
import org.coding.challenge.flowershop.service.impl.LiliesBundle.LiliesBundleSizes;
import org.junit.Before;
import org.junit.Test;

public class LiliesBundleTest {

    private LiliesBundle bundle;

    @Before
    public void before() throws Exception {
	bundle = new LiliesBundle(16);
    }

    @Test
    public void testPack() {
	bundle.pack();
	bundle = new LiliesBundle(10);
	bundle.pack();
	bundle.setOrderedPieces(15);
	bundle.pack();
	Assert.assertEquals(1,
		bundle.getLiliesBundleMap().get(LiliesBundleSizes.NINE)
			.intValue());
	Assert.assertEquals(1,
		bundle.getLiliesBundleMap().get(LiliesBundleSizes.SIX)
			.intValue());
	Assert.assertEquals(15, bundle.getOrderedPieces());

	bundle.pack();
    }

}
