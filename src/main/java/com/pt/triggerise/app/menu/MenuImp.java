package com.pt.triggerise.app.menu;

import java.util.*;

public class MenuImp {

    List<MenuEnum> menuEnumList = new ArrayList(Arrays.asList(MenuEnum.SHOW_PRODUCT,
                                                              MenuEnum.MENU_CHECK_OUT));

    public MenuImp() {
       startMenu();
    }

    public void startMenu() {
        int option = 0;
        do {
            new MenuDrawing().drawingMainMenu();
            Scanner scanner = new Scanner(System.in);
            System.out.print("Choose your option:");
            try {
                option = scanner.nextInt();
                if ( option > 0 && option <= menuEnumList.size() ) {
                    MenuEnum menuEnum = menuEnumList.get(option-1);
                    menuEnum.optionMenu();
                } else {
                    System.out.println("It's not a menu option");
                }
            } catch (InputMismatchException e) {
               System.out.println("Please! Just numbers. Try again!");
               System.out.println();
               startMenu();
            }
            System.out.println();
        } while(option != 0);
    }
}
