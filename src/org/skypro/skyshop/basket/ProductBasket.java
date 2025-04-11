package org.skypro.skyshop.basket;

import org.skypro.skyshop.product.Product;

public class ProductBasket {
    private Product[] products = new Product[5];
    private int productCount = 0;

    public void addProduct(Product product) {
        if (productCount < products.length) {
            products[productCount] = product;
            productCount++;
        } else {
            System.out.println("Не возможно добавить продукт, корзина полна");
        }
    }

    public int totalPrice() {
        int total = 0;
        for (int i = 0; i < productCount; i++) {
            total += products[i].getPriceProduct();
        }
        return total;
    }

    public void printBasket() {
        if (productCount == 0) {
            System.out.println("В корзине пусто.");
            return;
        }
        for (int i = 0; i < productCount; i++) {
            System.out.println(products[i].getNameProduct() + ": " + products[i].getPriceProduct() + " рублей.");
        }
        System.out.println("Итого: " + totalPrice() + " рублей.");
    }

    public boolean checkProduct(String name) {
        for (int i = 0; i < productCount; i++) {
            if (products[i].getNameProduct().equals(name)) {
                System.out.println("продукт: " + products[i].getNameProduct() + " найден в корзине.");
                return true;
            }
        }
        System.out.println("такого продукта нет в корзине: " + name);
        return false;
    }

    public void clearBasket() {
        products = new Product[5];
        productCount = 0;
    }

}