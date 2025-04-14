package org.skypro.skyshop.product;

public abstract class Product {
    private final String nameProduct;

    public Product(String nameProduct) {
        this.nameProduct = nameProduct;
    }

    public String getNameProduct() {
        return nameProduct;
    }

    public abstract int getPriceProduct();

    public abstract boolean isSpecial();

    @Override
    public String toString() {
        return nameProduct;
    }

}
