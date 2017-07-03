package co.cogent.coding.challenge.flowershop.service.impl;

import co.cogent.coding.challenge.flowershop.service.Packaging;

/**
 * Abstract class for Bundle Packaging for Flowers
 * 
 * @author val
 *
 */
public abstract class Bundle implements Packaging {

    @Override
    public abstract int pack();
}
