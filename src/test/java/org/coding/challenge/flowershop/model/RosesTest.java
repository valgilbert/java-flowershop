package org.coding.challenge.flowershop.model;

import junit.framework.Assert;

import org.coding.challenge.flowershop.model.ProductCodeEnum;
import org.coding.challenge.flowershop.model.Roses;
import org.junit.Before;
import org.junit.Test;

public class RosesTest {

    private Roses flower;

    @Before
    public void before() throws Exception {
	flower = new Roses(15);
    }

    @Test
    public void testPrice() {
	flower.packaging().pack();
	Assert.assertEquals(19.98, flower.price());
	Assert.assertEquals(15, flower.getOrderedPieces());
	Assert.assertEquals(ProductCodeEnum.ROSES, flower.code());
	Assert.assertEquals("ROSES", flower.name());

    }

    @Test
    public void testShowDetails() {
	flower.packaging().pack();
	flower.showDetails();
    }
}
