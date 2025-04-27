package org.skypro.skyshop.basket;

import org.skypro.skyshop.product.Product;

import java.util.ArrayList;
import java.util.List;

public class ProductBasket {
    private final List<Product> products = new ArrayList<>();

    public void addProduct(Product product) {
        products.add(product);
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

    public List<Product> removeProductName(String name) {
        List<Product> removeProducts = new ArrayList<>();
        for (int i = products.size() - 1; i >= 0; i--) {
            Product product = products.get(i);
            if (product == null || product.getNameProduct() == null) {
                continue;
            }
            if (product.getNameProduct().equalsIgnoreCase(name)) {
                removeProducts.add(product);
                products.remove(i);
            }
        }
        return removeProducts;
    }


}