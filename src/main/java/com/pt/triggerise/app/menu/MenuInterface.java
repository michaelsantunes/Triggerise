package com.pt.triggerise.app.menu;

public interface MenuInterface {

    void showMenu();
    void showData();

    default String getTitle(String title, String divisor) {
        title = "\n" + title + "\n" + divisor;
        return title;
    }
}
