package org.skypro.skyshop.basket;

import org.skypro.skyshop.product.Product;

import java.util.*;

public class ProductBasket {
    private final Map<String, List<Product>> mapProduct = new TreeMap<>();

    public void addProduct(Product product) {
        mapProduct.computeIfAbsent(product.getNameProduct(), k -> new ArrayList<>()).add(product);
    }

    public int totalPrice() {
        int total = 0;
        for (List<Product> sm : mapProduct.values()) {
            for (Product g : sm) {
                total += g.getPrice();
            }
        }
        return total;
    }

    public void printBasket() {
        if (mapProduct.isEmpty()) {
            System.out.println("в корзине пусто.");
            return;
        }
        int total = 0;
        int specialCount = 0;
        for (Map.Entry<String, List<Product>> entry : mapProduct.entrySet()) {
            for (Product product : entry.getValue()) {
                System.out.println(product.toString());
                total += product.getPrice();
                if (product.isSpecial()) {
                    specialCount++;
                }
            }
        }
        System.out.println("Итого: " + totalPrice());
        System.out.println("Специальных товаров: " + specialCount);
    }

    public boolean checkProduct(String name) {
        return mapProduct.containsKey(name);
    }

    public List<Product> removeProductName(String name) {
        List<Product> removeProducts = mapProduct.get(name);
        if (removeProducts != null) {
            mapProduct.remove(name);
            return removeProducts;
        } else {
            return Collections.emptyList();
        }
    }
}