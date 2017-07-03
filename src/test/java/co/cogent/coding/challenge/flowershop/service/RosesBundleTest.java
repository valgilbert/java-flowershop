package co.cogent.coding.challenge.flowershop.service;

import junit.framework.Assert;

import org.junit.Before;
import org.junit.Test;

import co.cogent.coding.challenge.flowershop.service.impl.RosesBundle;
import co.cogent.coding.challenge.flowershop.service.impl.RosesBundle.RosesBundleSizes;

public class RosesBundleTest {

    private RosesBundle bundle = new RosesBundle(10);

    @Before
    public void before() throws Exception {
	bundle = new RosesBundle(16);
    }

    @Test
    public void testPack() {
	bundle.pack();
	bundle = new RosesBundle(10);
	bundle.pack();
	bundle.setOrderedPieces(15);
	bundle.pack();
	Assert.assertEquals(1,
		bundle.getRosesBundleMap().get(RosesBundleSizes.TEN).intValue());
	Assert.assertEquals(1,
		bundle.getRosesBundleMap().get(RosesBundleSizes.FIVE)
			.intValue());
	Assert.assertEquals(15, bundle.getOrderedPieces());

	bundle.pack();
    }

}
