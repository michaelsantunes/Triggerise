package com.pt.triggerise.app.imp;

import com.pt.triggerise.app.product.ProductCheckOut;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class CheckOutTest {

    private int count;
    private int expectedQuantity;
    private double expectedPrice;
    private int quantityCheckOut;
    private double priceCheckOut;

    @Before
    public void setUp() throws Exception {
        initialize();
    }

    public void initialize() {
        count            = 0;
        expectedQuantity = 0;
        quantityCheckOut = 0;
        priceCheckOut    = 0d;
        expectedPrice    = 0d;
    }

    @Test
    public void testRandomCheckOut() {
        initialize();
        System.out.println("testRandomCheckOut");
        CheckOutImp checkOutImp = new CheckOutImp("Menu Check Out");
        while ( count < 10 ) {
            int index = new Random().nextInt(3);
            int quantity = new Random().nextInt(30);
            this.expectedQuantity += quantity;
            checkOutImp.add(index,quantity);
            count++;
        }
        checkOutImp.checkOutPrice();

        for ( ProductCheckOut productCheckOut : checkOutImp.getProductShowCheckOutList()) {
            System.out.println(productCheckOut.getCode() + " - " + productCheckOut.getPrice() + " - " +  productCheckOut.getQuantity());
            this.priceCheckOut += productCheckOut.getPrice();
            this.quantityCheckOut += productCheckOut.getQuantity();
        }
        Assert.assertEquals(this.expectedQuantity,this.quantityCheckOut);
        System.out.println("===============================================================================================");
    }

    @Test
    public void testCheckOutOneForEach() {
        initialize();
        System.out.println("testCheckOutOneForEach");
        CheckOutImp checkOutImp = new CheckOutImp("Menu Check Out");
        checkOutImp.add(0,1);
        checkOutImp.add(1,1);
        checkOutImp.add(2,1);
        checkOutImp.checkOutPrice();
        for ( ProductCheckOut productCheckOut : checkOutImp.getProductShowCheckOutList()) {
            System.out.println(productCheckOut.getCode() + " - " + productCheckOut.getPrice() + " - " + productCheckOut.getQuantity());
            this.priceCheckOut += productCheckOut.getPrice();
        }
        checkOutImp.showData();
        this.expectedPrice = 32.5;
        Assert.assertEquals((long) this.expectedPrice, (long) this.priceCheckOut);
    }

    @Test
    public void testCheckOut2Ticket1Hoodie() {
        initialize();
        System.out.println("testCheckOut2Ticket1Hoodie");
        CheckOutImp checkOutImp = new CheckOutImp("Menu Check Out");
        checkOutImp.add(0,2);
        checkOutImp.add(1,1);
        checkOutImp.checkOutPrice();
        for ( ProductCheckOut productCheckOut : checkOutImp.getProductShowCheckOutList()) {
            System.out.println(productCheckOut.getCode() + " - " + productCheckOut.getPrice() + " - " + productCheckOut.getQuantity());
            this.priceCheckOut += productCheckOut.getPrice();
        }
        checkOutImp.showData();
        this.expectedPrice = 25.0;
        Assert.assertEquals((long) this.expectedPrice, (long) this.priceCheckOut);
    }

    @Test
    public void testCheckOut1Ticket4Hoodie() {
        initialize();
        System.out.println("testCheckOut1Ticket4Hoodie");
        CheckOutImp checkOutImp = new CheckOutImp("Menu Check Out");
        checkOutImp.add(0,1);
        checkOutImp.add(1,4);
        checkOutImp.checkOutPrice();
        for ( ProductCheckOut productCheckOut : checkOutImp.getProductShowCheckOutList()) {
            System.out.println(productCheckOut.getCode() + " - " + productCheckOut.getPrice() + " - " + productCheckOut.getQuantity());
            this.priceCheckOut += productCheckOut.getPrice();
        }
        checkOutImp.showData();
        this.expectedPrice = 81.0;
        Assert.assertEquals((long) this.expectedPrice, (long) this.priceCheckOut);
    }

    @Test
    public void testCheckOut6Ticket7Hoodie9Hat() {
        initialize();
        System.out.println("testCheckOut6Ticket7Hoodie9Hat");
        CheckOutImp checkOutImp = new CheckOutImp("Menu Check Out");
        checkOutImp.add(0,6);
        checkOutImp.add(1,7);
        checkOutImp.add(2,9);
        checkOutImp.checkOutPrice();
        for ( ProductCheckOut productCheckOut : checkOutImp.getProductShowCheckOutList()) {
            System.out.println(productCheckOut.getCode() + " - " + productCheckOut.getPrice() + " - " + productCheckOut.getQuantity());
            this.priceCheckOut += productCheckOut.getPrice();
        }
        checkOutImp.showData();
        this.expectedPrice = 215.50;
        Assert.assertEquals((long) this.expectedPrice, (long) this.priceCheckOut);
    }

    @Test
    public void testTwoForOne() {
        int quantity = 2;
        double price = 5.0;
        count = 0;
        int checkOut = 1;
        List<Long> listPriceResult = new ArrayList<>();
        List<Long> expectedListPrice = new ArrayList(Arrays.asList(5L,5L,10L,10L,15L,15L,20L,20L,25L,25L,30L,30L,35L,35L,40L,40L,45L,45L,50L));
        while ( count <= 18) {
            int difference = checkOut - (checkOut / quantity);
            long value = (long) price * difference;
            listPriceResult.add(value);
            checkOut++;
            count++;
        }
        Assert.assertEquals(listPriceResult,expectedListPrice);
    }
}
