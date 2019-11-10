package com.practice.bestsellingproduct.pojo;

public class OrderBean {
    private int orderId;
    private String productPurchased;
    private String orderBy;
    private boolean activeOrder;

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public String getOrderBy() {
        return orderBy;
    }

    public void setOrderBy(String orderBy) {
        this.orderBy = orderBy;
    }

    public boolean isActiveOrder() {
        return activeOrder;
    }

    public void setActiveOrder(boolean activeOrder) {
        this.activeOrder = activeOrder;
    }

    public String getProductPurchased() {
        return productPurchased;
    }

    public void setProductPurchased(String productPurchased) {
        this.productPurchased = productPurchased;
    }
}
