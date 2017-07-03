package co.cogent.coding.challenge.flowershop.model;

import java.util.HashMap;
import java.util.Map;

/**
 * Product Code Enums for Items in the FlowerShop
 * 
 * @author val
 *
 */
public enum ProductCodeEnum {
    ROSES("R12"), LILIES("L09"), TULIPS("T58"), ;

    private static Map<String, ProductCodeEnum> map = new HashMap<String, ProductCodeEnum>();

    static {
	for (ProductCodeEnum productCode : ProductCodeEnum.values()) {
	    map.put(productCode.value, productCode);
	}
    }

    private String value;

    public String getValue() {
	return value;
    }

    private ProductCodeEnum(final String value) {
	this.value = value;
    }

    /**
     * Get the enum value of specified product code string
     * 
     * @param value
     * @return
     */
    public static ProductCodeEnum valueOfProductCode(final String value) {
	final ProductCodeEnum code = map.get(value);
	if (code == null) {
	    throw new IllegalArgumentException("Invalid ProductCode value: "
		    + value);
	}
	return code;
    }

}
