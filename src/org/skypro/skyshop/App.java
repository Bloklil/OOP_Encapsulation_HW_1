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
        Product product9 = new Product("груша", 12);
        basket.addProduct(product9);
        basket.addProduct(product2);
        basket.addProduct(product4);
        basket.addProduct(product5);
        basket.addProduct(product3);
        basket.addProduct(product1);
        basket2.addProduct(product6);
        basket2.addProduct(product7);
        basket2.addProduct(product8);
        basket2.addProduct(product6);
        basket.printBasketContents();
        String productName = "груша";
        String productNameTwoo = "кукуруза";

        if (basket.checkProduct(productName)) {
            System.out.println(productName + " есть в корзине.");
        } else {
            System.out.println(productName + ": нету в корзине.");
        }

        basket.totalPrice();

        int totalCoast = basket.totalPrice();
        System.out.println(totalCoast + " рублей.");
        if (basket.checkProduct(productNameTwoo)) {
            System.out.println(productNameTwoo + " есть в корзине.");
        } else {
            System.out.println(productNameTwoo + ": нету в корзине.");
        }

        basket2.clearBasket();
        basket2.printBasketContents();
        basket2.totalPrice();
        basket2.totalPrice();

        int total = basket2.totalPrice();
        System.out.println("В корзине " + total + " рублей.");

        if (basket2.checkProduct(productName)) {
            System.out.println(productName + " есть в корзине.");
        } else {
            System.out.println(productName + ": нету в корзине.");

        }
    }
}

