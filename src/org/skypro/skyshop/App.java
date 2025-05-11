package org.skypro.skyshop;

import org.skypro.skyshop.article.Article;
import org.skypro.skyshop.exception.BestResultNotFound;
import org.skypro.skyshop.product.DiscountedProduct;
import org.skypro.skyshop.product.FixPriceProduct;
import org.skypro.skyshop.product.Product;
import org.skypro.skyshop.basket.ProductBasket;
import org.skypro.skyshop.product.SimpleProduct;
import org.skypro.skyshop.search.SearchEngine;
import org.skypro.skyshop.search.Searchable;

import java.util.List;
import java.util.Set;

public class App {
    public static void main(String[] args) {

        ProductBasket basket = new ProductBasket();
        ProductBasket basket2 = new ProductBasket();
        SearchEngine engine = new SearchEngine();

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

        System.out.println("\n-------------корзина 1------------------\n");
        basket.printBasket();
        basket.totalPrice();
        System.out.println("\n-----------цена корзины 1-----------\n");
        int totalCoast = basket.totalPrice();
        System.out.println(totalCoast + " рублей.");
        System.out.println("\n-----------поиск товара в корзине 1---------\n");

        String productName = "слива";
        String productNameTwoo = "кукуруза";

        if (basket.checkProduct(productName)) {
            System.out.println(productName + " есть в корзине.");
        } else {
            System.out.println(productName + ": нету в корзине.");
        }
        if (basket.checkProduct(productNameTwoo)) {
            System.out.println(productNameTwoo + " есть в корзине.");
        } else {
            System.out.println(productNameTwoo + ": нету в корзине.");
        }
        System.out.println("\n-----------корзина 2---------\n");

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

        Article article3 = new Article("про бананы", "бананами нельзя кормить обезъян");
        Article article1 = new Article("хлеб-вреден", "хлеб вреден после 40, но это не точно");
        Article article2 = new Article("полезные статьи про молоко", "как же хорошо когда есть молоко");
        Article article4 = new Article("чай", "он тонизирует на весь день");
        Article article7 = new Article("чай про", "хороший состав");
        Article article8 = new Article("чай каркаде", "хороший состав");
        Article article9 = new Article("чай фи", "хороший состав");
        Article article10 = new Article("чай каскарпоне", "хороший состав");
        Article article5 = new Article("кофе", "кофе вреден из-за кофеина в больших количествах");
        Article article6 = new Article("цикорий", "прекрасная замена кофе");
        Article article12 = new Article("цикорий мен", "прекрасная замена кофе");

        engine.add(article2);
        engine.add(article3);
        engine.add(article1);
        engine.add(article4);
        engine.add(article5);
        engine.add(article6);
        engine.add(article7);
        engine.add(article8);
        engine.add(article9);
        engine.add(article10);
        engine.add(article12);


        System.out.println("\n-----------цена корзины 2-----------\n");
        int total = basket2.totalPrice();
        System.out.println("В корзине " + total + " рублей.");

        System.out.println("\n-----------поиск товара в корзине 2---------\n");
        if (basket2.checkProduct(productName)) {
            System.out.println(productName + " есть в корзине.");
        } else {
            System.out.println(productName + ": нету в корзине.");
        }
        System.out.println("\n-----------поиск---------\n");

        printSearchResults(engine, "чай");
        printSearchResults(engine, "коньяк");
        printSearchResults(engine, "цикорий");

        System.out.println("\n-----------------------\n");
        try {
            Product product = new SimpleProduct("", 100);
        } catch (IllegalArgumentException e) {
            System.err.println("Ошибка при создании товара: " + e.getMessage());
        }
        try {
            Product product = new SimpleProduct("сайра", 0);
        } catch (IllegalArgumentException e) {
            System.err.println("Ошибка при создании товара: " + e.getMessage());
        }
        try {
            Searchable bestMatch = engine.findBestMatch("бананы");
            System.out.println("Лучший результат поиска: " + bestMatch.getStringRepresentation());
        } catch (BestResultNotFound e) {
            System.err.println("Ошибка поиска: " + e.getMessage());
        }
        try {
            Searchable bestMatch = engine.findBestMatch("бананбананбананбанан");
            System.out.println("Лучший результат поиска: " + bestMatch.getStringRepresentation());
        } catch (BestResultNotFound e) {
            System.err.println("Ошибка поиска: " + e.getMessage());
        }

        printRemovedProducts(basket.removeProductName("банан"));

        basket.printBasket();

        printRemovedProducts(basket.removeProductName("вобла"));

        basket.printBasket();
    }

    private static void printSearchResults(SearchEngine engine, String search) {
        Set<Searchable> results = engine.search(search);
        for (Searchable item : results) {
            System.out.println(item.getStringRepresentation());
        }
    }

    private static void printRemovedProducts(List<Product> removed) {
        if (removed == null || removed.isEmpty()) {
            System.out.println("Список пуст.");
        } else {
            System.out.println("Удаленные продукты: ");
            for (Product product : removed) {
                System.out.println(product);
            }
        }
    }
}

