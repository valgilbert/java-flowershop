package org.coding.challenge.flowershop;

import junit.framework.Assert;

import org.coding.challenge.flowershop.FlowerShopOrderBuilder;
import org.coding.challenge.flowershop.model.ProductCodeEnum;
import org.junit.Before;
import org.junit.Test;

public class FlowerShopOrderBuilderTest {

    private FlowerShopOrderBuilder builder;

    @Before
    public void before() throws Exception {
	builder = new FlowerShopOrderBuilder();
    }

    @Test
    public void testAddItemToCart() {

	int nRoses = 10;
	int nTulips = 12;
	int nLilies = 15;

	builder.addItemToCart(nRoses, ProductCodeEnum.ROSES);
	builder.addItemToCart(nTulips, ProductCodeEnum.TULIPS);
	builder.addItemToCart(nLilies, ProductCodeEnum.LILIES);

	Assert.assertEquals(builder.getOrder().getItems().get(0)
		.getOrderedPieces(), nRoses);
	Assert.assertEquals(builder.getOrder().getItems().get(0).code(),
		ProductCodeEnum.ROSES);

	Assert.assertEquals(builder.getOrder().getItems().get(1)
		.getOrderedPieces(), nTulips);
	Assert.assertEquals(builder.getOrder().getItems().get(1).code(),
		ProductCodeEnum.TULIPS);

	Assert.assertEquals(builder.getOrder().getItems().get(2)
		.getOrderedPieces(), nLilies);
	Assert.assertEquals(builder.getOrder().getItems().get(2).code(),
		ProductCodeEnum.LILIES);
    }

}
