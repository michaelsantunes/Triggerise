package com.pt.triggerise.app.product;

public class ProductCheckOut extends ProductCode {

    private Double price;
    private int quantity;
    private Product product;

    public ProductCheckOut(String code, Double price, int quantity) {
        super(code);
        this.price = price;
        this.quantity = quantity;
    }

    @Override
    public String getCode() {
        return super.getCode();
    }

    public Double getPrice() {
        return price;
    }

    public int getQuantity() {
        return quantity;
    }

    public ProductCheckOut setQuantity(int quantity) {
        this.quantity = quantity;
        return null;
    }
}





