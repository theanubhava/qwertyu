package com.practice.bestsellingproduct.service.impl;

import com.practice.bestsellingproduct.database.SQLDB;
import com.practice.bestsellingproduct.pojo.ProductBean;
import com.practice.bestsellingproduct.pojo.PurchaseRequestHolder;
import com.practice.bestsellingproduct.service.OrderService;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
public class OrderServiceImpl implements OrderService {
    SQLDB sqldb=SQLDB.getInstance();

    @Override
    public String purchaseOrder(List<PurchaseRequestHolder> purchaseRequestHolderList) {
        StringBuilder sb = new StringBuilder();
        for(PurchaseRequestHolder prh: purchaseRequestHolderList){
            sb.append(purchaseProductPerOrder(prh.getUserId(),prh.getProdList())).append("\n");
        }
        return sb.toString();
    }

    @Override
    public String returnOrder(List<PurchaseRequestHolder> purchaseRequestHolderList) {
        StringBuilder sb = new StringBuilder();
        for(PurchaseRequestHolder prh: purchaseRequestHolderList){
            sb.append(returnProductPerOrder(prh.getUserId(),prh.getProdList())).append("\n");
        }
        return sb.toString();
    }

    public String purchaseProductPerOrder(String userId, List<String> products){
        StringBuilder sb = new StringBuilder();
        sb.append(userId).append(" purchased-");
        for (String prodId : products) {
            ProductBean prod = new ProductBean();
            if (sqldb.getProductDetailMap().get(prodId) == null) {
                prod.setProductId(prodId);
                prod.setActiveProduct(true);
                prod.setPurchasedByUsers(new HashMap<>());
                sqldb.getProductDetailMap().put(prodId, prod);
            }
            prod = sqldb.getProductDetailMap().get(prodId);

            Map<String, Integer> mapList = prod.getPurchasedByUsers();

            if (mapList.get(userId) == null)
                mapList.put(userId, 0);

            mapList.put(userId,mapList.get(userId)+ 1);
            sb.append(prodId).append(",");
        }
        return sb.toString();
    }

    public String returnProductPerOrder(String userId, List<String> prodList){
        StringBuilder sb = new StringBuilder();
        sb.append(userId).append(" returned-");
        for(String prodId : prodList){
            ProductBean prod = sqldb.getProductDetailMap().get(prodId);
            if(prod==null)
                continue;
            Map<String,Integer> mapList =prod.getPurchasedByUsers();
            if(mapList.get(userId)==null)
                continue;
            if(mapList.get(userId)==1){
                sqldb.getProductDetailMap().remove(prodId);
            }else {
                mapList.put(userId, mapList.get(userId) - 1);
            }
            sb.append(prodId).append(",");
        }
        return sb.toString();
    }
}
