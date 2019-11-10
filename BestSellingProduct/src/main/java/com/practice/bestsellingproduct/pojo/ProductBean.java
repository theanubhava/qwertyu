package com.practice.bestsellingproduct.pojo;

import java.util.Map;

public class ProductBean {
    private String productId;
    private double price;
    private Map<String,Integer> purchasedByUsers;
    private boolean activeProduct;

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public Map<String, Integer> getPurchasedByUsers() {
        return purchasedByUsers;
    }

    public void setPurchasedByUsers(Map<String, Integer> purchasedByUsers) {
        this.purchasedByUsers = purchasedByUsers;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public boolean isActiveProduct() {
        return activeProduct;
    }

    public void setActiveProduct(boolean activeProduct) {
        this.activeProduct = activeProduct;
    }
}
