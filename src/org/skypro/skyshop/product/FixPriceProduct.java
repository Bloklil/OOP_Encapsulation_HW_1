package org.skypro.skyshop.product;

import org.skypro.skyshop.search.Searchable;

public class FixPriceProduct extends Product implements Searchable {
    private static final int fixPrice = 199;

    public FixPriceProduct(String nameProduct) {
        super(nameProduct);
    }

    @Override
    public int getPrice() {
        return fixPrice;
    }

    @Override
    public boolean isSpecial() {
        return true;
    }

    @Override
    public String toString() {
        return super.toString() + ", фиксированная цена: " + getPrice() + " рублей.";
    }

    @Override
    public String getSearchTerm() {
        return getName();
    }

    @Override
    public String getName() {
        return getNameProduct();
    }
}
