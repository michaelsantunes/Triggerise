package com.pt.triggerise.app.product;

import java.util.ArrayList;
import java.util.List;

public class Product extends ProductCode {

    private String name;
    private Double price;
    private ProductDiscountRulesEnum productDiscount;

    public Product(String code, String name, Double price) {
        super(code);
        this.name = name;
        this.price = price;
    }

    @Override
    public String getCode() {
        return super.getCode();
    }

    public String getName() {
        return name;
    }

    public Double getPrice() {
        return price;
    }


    public static List<Product> productListRepository() {
        List<Product> productList;
        productList = new ArrayList<>();
        productList.add(new Product("TICKET", "Triggerise Ticket", 5.00));
        productList.add(new Product("HOODIE", "Triggerise Hoodie", 20.00));
        productList.add(new Product("HAT", "Triggerise Hat", 7.50));
        return productList;
    }

    public static String printRules() {
        return "TICKET: 2 FOR 1 \nHOODIE: >= 3 NEW PRICE 19.00";
    }
}
