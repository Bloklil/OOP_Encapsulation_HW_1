package org.skypro.skyshop.product;

import org.skypro.skyshop.Searchable;

public class DiscountedProduct extends Product implements Searchable {
    private final int basePrice;
    private final int discountPersent;

    public DiscountedProduct(String nameProduct, int basePrice, int discountPersent) {
        super(nameProduct);
        this.basePrice = basePrice;
        this.discountPersent = discountPersent;
    }

    public int getPrice() {
        return basePrice * (100 - discountPersent) / 100;
    }

    @Override
    public boolean isSpecial() {
        return true;
    }

    @Override
    public String toString() {
        return super.toString() + ": " + getPrice() + " (скидка: " + discountPersent + " %)";
    }

    @Override
    public String getSearchTerm() {
        return getNameProduct();
    }

    @Override
    public String getContent() {
        return "DiscountedProduct";
    }

    @Override
    public String getName() {
        return getNameProduct();
    }
}

