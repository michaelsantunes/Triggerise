package com.pt.triggerise.app.menu;
import com.pt.triggerise.app.imp.CheckOutImp;
import com.pt.triggerise.app.imp.ProductImp;


public enum MenuEnum {
    SHOW_PRODUCT {
        @Override
        public void optionMenu() {
            ProductImp productImp = new ProductImp("Product List");
            productImp.showData();
        }
    },
    MENU_CHECK_OUT {
        @Override
        public void optionMenu() {
            CheckOutImp checkOutImp = new CheckOutImp("Menu Check Out");
            checkOutImp.showCheckOutMenu();
        }
    };

    abstract void optionMenu();

}