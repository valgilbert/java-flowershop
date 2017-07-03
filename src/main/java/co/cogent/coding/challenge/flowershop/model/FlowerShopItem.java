package co.cogent.coding.challenge.flowershop.model;

import co.cogent.coding.challenge.flowershop.service.Packaging;

/**
 * Interface for FlowerShopItem
 * 
 * @author val
 *
 */
public interface FlowerShopItem {

    public int getOrderedPieces();

    public String name();

    public ProductCodeEnum code();

    public Packaging packaging();

    public double price();

    public void showDetails();

}
