package org.skypro.skyshop.product;

public class DiscountedProduct extends Product {
    private final int basePrice;
    private final int discountPersent;

    public DiscountedProduct(String nameProduct, int basePrice, int discountPersent) {
        super(nameProduct);
        this.basePrice = basePrice;
        this.discountPersent = discountPersent;
    }

    public int getPriceProduct() {
        return basePrice * (100 - discountPersent) / 100;
    }

    @Override
    public boolean isSpecial() {
        return true;
    }

    @Override
    public String toString() {
        return super.toString() + ": " + getPriceProduct() + " (скидка: " + discountPersent + " %)";
    }
}

