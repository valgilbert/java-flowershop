package co.cogent.coding.challenge.flowershop.model;

import co.cogent.coding.challenge.flowershop.service.Packaging;

/**
 * Abstract class for Flower
 * 
 * @author val
 *
 */
public abstract class Flower implements FlowerShopItem {

    public abstract Packaging packaging();

}
