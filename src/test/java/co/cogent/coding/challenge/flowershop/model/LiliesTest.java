package co.cogent.coding.challenge.flowershop.model;

import junit.framework.Assert;

import org.junit.Before;
import org.junit.Test;

public class LiliesTest {

    private Lilies flower;

    @Before
    public void before() throws Exception {
	flower = new Lilies(15);
    }

    @Test
    public void testPrice() {
	flower.packaging().pack();
	Assert.assertEquals(41.9, flower.price());
	Assert.assertEquals(15, flower.getOrderedPieces());
	Assert.assertEquals(ProductCodeEnum.LILIES, flower.code());
	Assert.assertEquals("LILIES", flower.name());

    }

    @Test
    public void testShowDetails() {
	flower.packaging().pack();
	flower.showDetails();
    }
}
