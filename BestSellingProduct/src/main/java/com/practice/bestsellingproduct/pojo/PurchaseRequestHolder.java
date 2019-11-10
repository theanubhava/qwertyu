package com.practice.bestsellingproduct.pojo;

import java.util.List;

public class PurchaseRequestHolder {
    private String userId;
    private List<String> prodList;

    public List<String> getProdList() {
        return prodList;
    }

    public void setProdList(List<String> prodList) {
        this.prodList = prodList;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }
}

