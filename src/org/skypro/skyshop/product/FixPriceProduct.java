package org.skypro.skyshop.product;

public class FixPriceProduct extends Product {
    private final int FIXPRICE = 199;

    public FixPriceProduct(String nameProduct) {
        super(nameProduct);
    }

    @Override
    public int getPriceProduct() {
        return FIXPRICE;
    }

    @Override
    public boolean isSpecial() {
        return true;
    }

    @Override
    public String toString() {
        return super.toString() + ", фиксированная цена: " + getPriceProduct() + " рублей.";
    }
}
