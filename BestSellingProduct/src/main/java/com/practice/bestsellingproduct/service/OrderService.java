package com.practice.bestsellingproduct.service;

import com.practice.bestsellingproduct.pojo.PurchaseRequestHolder;

import java.util.List;

public interface OrderService {
    public String purchaseOrder(List<PurchaseRequestHolder> purchaseRequestHolderList);
    public String returnOrder(List<PurchaseRequestHolder> purchaseRequestHolderList);
}
