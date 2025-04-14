package org.skypro.skyshop;

import org.skypro.skyshop.product.DiscountedProduct;
import org.skypro.skyshop.product.FixPriceProduct;
import org.skypro.skyshop.product.Product;
import org.skypro.skyshop.basket.ProductBasket;
import org.skypro.skyshop.product.SimpleProduct;

public class App {
    public static void main(String[] args) {
        ProductBasket basket = new ProductBasket();
        ProductBasket basket2 = new ProductBasket();

        Product banan = new SimpleProduct("банан", 123);
        Product cocos = new SimpleProduct("кокос", 678);
        Product chleb = new SimpleProduct("хлеб", 31);
        Product vinograd = new SimpleProduct("виноград", 345);
        Product gribi = new SimpleProduct("грибы", 123);
        Product grusha = new SimpleProduct("груша", 64);
        Product ris = new SimpleProduct("рис", 99);
        Product grechka = new SimpleProduct("гречка", 123);
        Product sliva = new SimpleProduct("слива", 12);
        Product water = new DiscountedProduct("вода", 100, 10);
        Product limonad = new DiscountedProduct("лимонад", 409, 15);
        Product konyak = new FixPriceProduct("коньяк");
        Product popcorn = new FixPriceProduct("попкорн");

        basket.addProduct(banan);
        basket.addProduct(limonad);
        basket.addProduct(konyak);
        basket.addProduct(sliva);
        basket2.addProduct(gribi);
        basket2.addProduct(grusha);
        basket2.addProduct(ris);
        basket2.addProduct(grechka);
        basket2.addProduct(water);
        basket2.addProduct(popcorn);
        basket.printBasket();
        basket.totalPrice();
        String productName = "слива";
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
        basket2.printBasket();
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

