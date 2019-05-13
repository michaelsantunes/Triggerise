package com.pt.triggerise.app.imp;

import com.pt.triggerise.app.common.DivisorSystem;
import com.pt.triggerise.app.menu.MenuDrawing;
import com.pt.triggerise.app.menu.MenuInterface;
import com.pt.triggerise.app.product.Product;

public class ProductImp implements MenuInterface, DivisorSystem {

    private String title;

    public ProductImp(String title) {
        this.title = title;
    }

    @Override
    public void showMenu() {
        System.out.println(getTitle(this.title,getDivisor()));
        System.out.print(new MenuDrawing().drawingProductMenu().toString());
        System.out.println();
    }

    @Override
    public void showData() {
        System.out.println(getTitle(this.title,getDivisor()));
        for (Product product : new Product(null).productListRepository() ) {
            System.out.println("Code: " + product.getCode());
            System.out.println("Product: " + product.getName());
            System.out.println("Price: " + product.getPrice());
            System.out.println(getDivisor());
        }
        System.out.print("Rules\n");
        System.out.println(getDivisor());
        System.out.print(new Product(null).printRules());
        System.out.println();
    }
}
