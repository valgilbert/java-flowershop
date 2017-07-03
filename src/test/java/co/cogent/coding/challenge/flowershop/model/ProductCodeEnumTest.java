package co.cogent.coding.challenge.flowershop.model;

import static org.junit.Assert.fail;
import junit.framework.Assert;

import org.junit.Test;

public class ProductCodeEnumTest {

    @Test(expected = IllegalArgumentException.class)
    public void testValueOfProductCode() {
	Assert.assertEquals(ProductCodeEnum.ROSES,
		ProductCodeEnum.valueOfProductCode("R12"));
	Assert.assertEquals(ProductCodeEnum.LILIES,
		ProductCodeEnum.valueOfProductCode("L09"));
	Assert.assertEquals(ProductCodeEnum.TULIPS,
		ProductCodeEnum.valueOfProductCode("T58"));
	Assert.assertEquals("R12", ProductCodeEnum.ROSES.getValue());
	Assert.assertEquals("L09", ProductCodeEnum.LILIES.getValue());
	Assert.assertEquals("T58", ProductCodeEnum.TULIPS.getValue());
	ProductCodeEnum.valueOfProductCode("Invalid Code");
	fail("Should Throw Exception for invalid code");
    }
}
