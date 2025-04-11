package org.skypro.skyshop;

import org.skypro.skyshop.product.Product;
import org.skypro.skyshop.basket.ProductBasket;

public class App {
    public static void main(String[] args) {
        ProductBasket basket = new ProductBasket();
        ProductBasket basket2 = new ProductBasket();
        Product product1 = new Product("банан", 123);
        Product product2 = new Product("кокос", 678);
        Product product3 = new Product("хлеб", 31);
        Product product4 = new Product("виноград", 345);
        Product product5 = new Product("грибы", 123);
        Product product6 = new Product("груша", 64);
        Product product7 = new Product("рис", 99);
        Product product8 = new Product("гречка", 123);
        basket.addProduct(product1);
        basket.addProduct(product3);
        basket.addProduct(product3);
        basket.addProduct(product3);
        basket.addProduct(product3);
        basket.addProduct(product2);
        basket2.addProduct(product7);
        basket2.addProduct(product8);
        basket2.addProduct(product5);
        basket2.addProduct(product6);
        System.out.println("Стоимость корзины: " + basket2.totalPrice() + " рублей.");
        basket2.printBasket();
        basket2.checkProduct("груша");
        basket2.checkProduct("свекла");
        basket2.clearBasket();
        basket2.printBasket();
        System.out.println("Стоимость корзины: " + basket2.totalPrice() + " рублей.");
        basket2.checkProduct("свекла");

    }
}
