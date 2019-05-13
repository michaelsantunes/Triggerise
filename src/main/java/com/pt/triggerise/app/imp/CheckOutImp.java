package com.pt.triggerise.app.imp;

import com.pt.triggerise.app.common.DivisorSystem;
import com.pt.triggerise.app.product.Product;
import com.pt.triggerise.app.product.ProductCheckOut;
import com.pt.triggerise.app.product.ProductDiscountRulesEnum;

import java.util.*;
import java.util.stream.Collectors;

public class CheckOutImp extends ProductImp implements DivisorSystem {

    private List<ProductCheckOut> productAddCheckOut;
    private List<ProductCheckOut> productShowCheckOutList;
    private List<Product> productList;
    private Set<ProductDiscountRulesEnum> productDiscountRulesEnums;

    public CheckOutImp(String title) {
        super(title);
        this.productAddCheckOut = new ArrayList<>();
        this.productShowCheckOutList = new ArrayList<>();
        this.productList = Product.productListRepository();
        this.productDiscountRulesEnums = new HashSet<>(EnumSet.allOf(ProductDiscountRulesEnum.class));
    }

    public void showCheckOutMenu() {
        int option = 1;
        while ( option > 0 ) {
            super.showMenu();
            Scanner scanner = new Scanner(System.in);
            System.out.print("Choose your option:");
            try {
                option = scanner.nextInt();
                if ( option == 0) return;
                if ( option > 0 && option <= productList.size() ) {
                    System.out.print("Quantity:");
                    int quantity = scanner.nextInt();
                    add(option - 1, quantity);
                } else {
                    System.out.println("It's not a menu option");
                }
            } catch (InputMismatchException e) {
                System.out.println("Please! Just numbers. Try again!");
                System.out.println();
            } finally {
                if ( option == 0 ) {
                    checkOutPrice();
                    showData();
                }
            }
        }
    }

    public void add(int index, int quantity){
        Product product = this.productList.get(index);
        this.productAddCheckOut.add(new ProductCheckOut(product.getCode(), product.getPrice(), quantity));
        System.out.println("Save!");
    }

    public void checkOutPrice() {
        //group by code
        Map<String, Integer> groupCheckOutByCode = this.productAddCheckOut.stream().
                collect(Collectors.groupingBy(p -> p.getCode(),
                        Collectors.summingInt(p -> p.getQuantity())));

        groupCheckOutByCode.forEach((code, checkOutQuantity) -> {
            ProductCheckOut checkOut = this.productAddCheckOut.stream().filter(parameter -> parameter.getCode().
                    equalsIgnoreCase(code)).findFirst().orElse(null);
            if (checkOut instanceof ProductCheckOut) {
                checkOut.setQuantity(checkOutQuantity);
                ProductDiscountRulesEnum productDiscountRulesEnum =
                                this.productDiscountRulesEnums.stream().
                                filter(parameter -> parameter.name().
                                equalsIgnoreCase(code)).
                                findFirst().
                                orElse(null);
                if ( productDiscountRulesEnum == null ) productDiscountRulesEnum = ProductDiscountRulesEnum.DEFAULT;
                this.productShowCheckOutList.add(new ProductCheckOut(code,productDiscountRulesEnum.priceCalculating(checkOut),checkOutQuantity));
            }
        });
    }

    @Override
    public void showData() {
        System.out.println();
        System.out.println("=================== CHECK-OUT ===================");
        double total = 0D;
        for ( ProductCheckOut productCheckOut : this.productShowCheckOutList) {
            System.out.println("Product: " + productCheckOut.getCode() + " - Quantity: " +  productCheckOut.getQuantity() + " - Price: " + productCheckOut.getPrice());
            total += productCheckOut.getPrice();
        }
        System.out.println(getDivisor());
        System.out.println("Total: " + total);
        System.out.println();
    }

    public List<ProductCheckOut> getProductAddCheckOut() {
        return productAddCheckOut;
    }

    public List<ProductCheckOut> getProductShowCheckOutList() {
        return productShowCheckOutList;
    }

    public List<Product> getProductList() {
        return productList;
    }

    public Set<ProductDiscountRulesEnum> getProductDiscountRulesEnums() {
        return productDiscountRulesEnums;
    }
}
