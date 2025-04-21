package org.skypro.skyshop;

import org.skypro.skyshop.article.Article;
import org.skypro.skyshop.product.DiscountedProduct;
import org.skypro.skyshop.product.FixPriceProduct;
import org.skypro.skyshop.product.Product;
import org.skypro.skyshop.basket.ProductBasket;
import org.skypro.skyshop.product.SimpleProduct;

public class App {


    public static void main(String[] args) {
        ProductBasket basket = new ProductBasket();
        ProductBasket basket2 = new ProductBasket();
        SearchEngine engine = new SearchEngine(20);

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
        basket2.addProduct(sliva);
        basket2.addProduct(water);
        basket2.addProduct(cocos);
        basket2.addProduct(chleb);
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


        engine.add(limonad);
        engine.add(popcorn);
        engine.add(konyak);
        engine.add(grechka);
        engine.add(chleb);
        engine.add(cocos);
        engine.add(gribi);
        engine.add(vinograd);
        engine.add(banan);
        engine.add(grusha);
        engine.add(ris);
        engine.add(sliva);
        engine.add(water);
        Article articleTree = new Article("про бананы", "бананами нельзя кормить обезъян");
        Article articleOne = new Article("хлеб-вреден", "хлеб вреден после 40, но это не точно");
        Article articleTwo = new Article("полезные статьи про молоко", "как же хорошо когда есть молоко");
        engine.add(articleTwo);
        engine.add(articleTree);
        engine.add(articleOne);


        int total = basket2.totalPrice();
        System.out.println("В корзине " + total + " рублей.");

        if (basket2.checkProduct(productName)) {
            System.out.println(productName + " есть в корзине.");
        } else {
            System.out.println(productName + ": нету в корзине.");

        }
        System.out.println("результаты поиска: ");
        printResults(engine.search("бананы"));
        printResults(engine.search("вреден"));

        printSearchResults(engine.search("попкорн"));
        printSearchResults(engine.search("вода"));
        printSearchResults(engine.search("слива"));
    }

    public static void printResults(Searchable[] results) {
        for (Searchable s : results) {
            if (s != null) {
                System.out.println(s.getStringRepresentation());
            }
        }
    }

    private static void printSearchResults(Searchable[] results) {
        for (Searchable item : results) {
            if (item != null) {
                System.out.println(item.getStringRepresentation());
            }
        }
    }

}

