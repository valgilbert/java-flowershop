package co.cogent.coding.challenge.flowershop.model;

import junit.framework.Assert;

import org.junit.Before;
import org.junit.Test;

public class TulipsTest {

    private Tulips flower;

    @Before
    public void before() throws Exception {
	flower = new Tulips(17);
    }

    @Test
    public void testPrice() {
	flower.packaging().pack();
	Assert.assertEquals(32.89, flower.price());
	Assert.assertEquals(17, flower.getOrderedPieces());
	Assert.assertEquals(ProductCodeEnum.TULIPS, flower.code());

    }

    @Test
    public void testShowDetails() {
	flower.packaging().pack();
	flower.showDetails();
    }
}
