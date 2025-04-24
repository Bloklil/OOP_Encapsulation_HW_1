package org.skypro.skyshop.basket;

import org.skypro.skyshop.product.Product;

public class ProductBasket {
    private final Product[] products = new Product[5];

    public void addProduct(Product product) {
        for (int i = 0; i < products.length; i++) {
            if (products[i] == null) {
                products[i] = product;
                return;
            }
        }
        System.out.println("корзина полна.");
    }

    public int totalPrice() {
        int total = 0;
        for (Product product : products) {
            if (product != null) {
                total += product.getPrice();
            }
        }
        return total;
    }

    public void printBasket() {
        boolean empty = true;
        int specialCount = 0;

        for (Product product : products) {
            if (product != null) {
                System.out.println(product);
                if (product.isSpecial()) {
                    specialCount++;
                }
                empty = false;
            }
        }

        if (empty) {
            System.out.println("в корзине пусто");
        } else {
            System.out.println("Итого: " + totalPrice());
            System.out.println("Специальных товаров: " + specialCount);
        }
    }

    public boolean checkProduct(String name) {
        for (Product product : products) {
            if (product != null && product.getNameProduct().equalsIgnoreCase(name)) {
                return true;
            }
        }
        return false;
    }

    public void clearBasket() {
        for (int i = 0; i < products.length; i++) {
            products[i] = null;
        }
        System.out.println(" корзина очищена.");
    }
}