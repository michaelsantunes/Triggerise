package com.pt.triggerise.app.menu;

import com.pt.triggerise.app.common.DivisorSystem;
import com.pt.triggerise.app.product.Product;


public class MenuDrawing implements DivisorSystem {

    public void drawingMainMenu() {
        System.out.println(getDivisor());
        System.out.println("|  Main Menu                             |");
        System.out.println("|  [1] Show Product                      |");
        System.out.println("|  [2] Check-Out                         |");
        System.out.println("|  [0] Exit                              |");
        System.out.println(getDivisor());
    }

    public StringBuilder drawingProductMenu() {
        StringBuilder options = new StringBuilder();
        int menuOption = 1;
        for ( Product products : new Product(null).productListRepository() ) {
            options.append("[").append(menuOption).append("]").append(" ").append(products.getCode()).append("\n");
            menuOption++;
        }
        options.append("[0] FINISH");
        return options;
    }
}


