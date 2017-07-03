package org.coding.challenge.flowershop;

import java.util.Scanner;

import org.coding.challenge.flowershop.model.FlowerShopOrder;
import org.coding.challenge.flowershop.model.ProductCodeEnum;
import org.coding.challenge.flowershop.service.impl.LiliesBundle.LiliesBundleSizes;
import org.coding.challenge.flowershop.service.impl.RosesBundle.RosesBundleSizes;
import org.coding.challenge.flowershop.service.impl.TulipsBundle.TulipsBundleSizes;

public class FlowerShopDemo {

    public static void main(String[] args) {
	FlowerShopOrderBuilder builder = new FlowerShopOrderBuilder();

	System.out.println("Reading from user input...");
	System.out
		.println("Order input in this format: \"<NUMBER> <PRODUCT_CODE>\". For Example \"12 R12\" for 12 Roses.");
	System.out.print("Product Codes: ");
	for (ProductCodeEnum product : ProductCodeEnum.values()) {
	    System.out.print(product + " ProductCode[" + product.getValue()
		    + "], ");
	}
	System.out.println("\n\nRoses Bundle Sizes");
	for (RosesBundleSizes sizes : RosesBundleSizes.values()) {
	    System.out.print("Size[" + sizes.value + "] Price[$ " + sizes.price
		    + "], ");
	}
	System.out.println("\n\nLilies Bundle Sizes");
	for (LiliesBundleSizes sizes : LiliesBundleSizes.values()) {
	    System.out.print("Size[" + sizes.value + "] Price[" + sizes.price
		    + "], ");
	}
	System.out.println("\n\nTulips Bundle Sizes");
	for (TulipsBundleSizes sizes : TulipsBundleSizes.values()) {
	    System.out.print("Size[" + sizes.value + "] Price[" + sizes.price
		    + "], ");
	}
	System.out
		.println("\n\nEnter SUBMIT to submit order. Enter newline to exit.");

	Scanner scan = new Scanner(System.in);

	try {
	    String input;
	    FlowerShopOrder order = null;

	    do {
		input = scan.nextLine();

		if (input != null && !input.isEmpty()) {
		    if ("SUBMIT".equalsIgnoreCase(input)) {

			// show items
			System.out.println("Order Details");
			System.out
				.println("=======================================");
			if (order != null) {
			    order.showItems();
			}
			System.out
				.println("=======================================");
		    } else {
			try {
			    final String[] orderParams = input.split(" ");
			    order = builder.addItemToCart(Integer
				    .parseInt(orderParams[0]), ProductCodeEnum
				    .valueOfProductCode(orderParams[1]));
			} catch (Exception e) {
			    System.err
				    .println("Order input in this format: \"<NUMBER> <PRODUCT_CODE>\". For Example \"12 R12\" for 12 Roses.");
			}
		    }
		}

	    } while (input != null && !input.isEmpty());

	    System.out.println("Exiting program...");

	} catch (Exception e) {
	    System.err.println(e.getMessage());
	    System.exit(-1);
	} finally {
	    scan.close();
	}
    }
}
