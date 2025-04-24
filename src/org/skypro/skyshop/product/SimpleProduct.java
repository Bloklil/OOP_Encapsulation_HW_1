package org.skypro.skyshop.product;

import org.skypro.skyshop.Searchable;

public class SimpleProduct extends Product implements Searchable {
    private final int priceProduct;

    public SimpleProduct(String nameProduct, int priceProduct) {
        super(nameProduct);
        if (priceProduct <= 0) {
            throw new IllegalArgumentException("Цена товара должна быть больше 0.");
        }
        this.priceProduct = priceProduct;
    }

    @Override
    public int getPrice() {
        return priceProduct;
    }

    @Override
    public boolean isSpecial() {
        return false;
    }

    @Override
    public String toString() {
        return super.toString() + ": " + getPrice() + " рублей.";
    }

    @Override
    public String getSearchTerm() {
        return getName();
    }

    @Override
    public String getContent() {
        return "SimpleProduct";
    }

    @Override
    public String getName() {
        return getNameProduct();
    }
}
