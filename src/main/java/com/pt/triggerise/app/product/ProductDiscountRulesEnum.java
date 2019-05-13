package com.pt.triggerise.app.product;

public enum ProductDiscountRulesEnum {
    TICKET {
        @Override
        public double priceCalculating(ProductCheckOut productCheckOut) {
            if ( productCheckOut.getQuantity() >= 2 ) {
                int difference = productCheckOut.getQuantity() - (productCheckOut.getQuantity() / 2);
                return productCheckOut.getPrice() * difference;

            }
            return productCheckOut.getQuantity() * productCheckOut.getPrice();
        }
    },
    HOODIE {
        @Override
        public double priceCalculating(ProductCheckOut productCheckOut) {
            if ( productCheckOut.getQuantity() >= 3 )
                return productCheckOut.getQuantity() * 19.0;
            return productCheckOut.getQuantity() * productCheckOut.getPrice();
        }
    },
    DEFAULT {
        @Override
        public double priceCalculating(ProductCheckOut productCheckOut) {
            return productCheckOut.getPrice() * productCheckOut.getQuantity();
        }
    };

    public abstract double priceCalculating(ProductCheckOut productCheckOut);
}
