package org.skypro.skyshop.basket;

import org.skypro.skyshop.product.Product;

import java.util.*;

public class ProductBasket {
    private final Map<String, List<Product>> mapProduct = new TreeMap<>();

    public void addProduct(Product product) {
        mapProduct.computeIfAbsent(product.getNameProduct(), k -> new ArrayList<>()).add(product);
    }

    public int totalPrice() {
        return mapProduct.values().stream()
                .flatMap(Collection::stream)
                .mapToInt(Product::getPrice)
                .sum();
    }

    public void printBasket() {
        if (mapProduct.isEmpty()) {
            System.out.println("в корзине пусто.");
            return;
        }

        long specialCount = getSpecialCount();
        mapProduct.values().stream()
                .flatMap(Collection::stream)
                .forEach(System.out::println);

        System.out.println("Итого: " + totalPrice() + " рублей.");
        System.out.println("Специальных товаров: " + specialCount);
    }

    private long getSpecialCount() {
        return mapProduct.values().stream()
                .flatMap(Collection::stream)
                .filter(Product::isSpecial)
                .count();
    }


    public boolean checkProduct(String name) {
        return mapProduct.containsKey(name);
    }

    public List<Product> removeProductName(String name) {
        return mapProduct.remove(name);
    }
}