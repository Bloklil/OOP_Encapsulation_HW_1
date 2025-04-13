package org.skypro.skyshop.basket;

import org.skypro.skyshop.product.Product;

public class ProductBasket {
    private Product[] products = new Product[5];

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
                total += product.getPriceProduct();
            }
        }
        return total;
    }

        public void printBasketContents () {
            boolean isEmpty = true;
            for (Product product : products) {
                if (product != null) {
                    System.out.println(product.getNameProduct() + ": " + product.getPriceProduct());
                    isEmpty = false;
                }
            }
            if (isEmpty) {
                System.out.println("В корзине пусто.");
            } else {
                System.out.println("Итого: " + totalPrice()+ " рублей.");
            }
        }

    public boolean checkProduct (String name) {
        for (int i = 0; i < products.length; i++) {
            if (products[i]!=null && products[i].getNameProduct().equalsIgnoreCase(name)) {
                return true;
            }
        }
        return false;
    }

        public void clearBasket () {
            for (int i = 0; i < products.length; i++) {
                products[i] = null;
            }
            System.out.println(" корзина очищена.");
        }
    }