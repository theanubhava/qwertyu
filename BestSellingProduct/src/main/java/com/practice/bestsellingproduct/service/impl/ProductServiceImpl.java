package com.practice.bestsellingproduct.service.impl;

import com.practice.bestsellingproduct.database.SQLDB;
import com.practice.bestsellingproduct.pojo.ProductBean;
import com.practice.bestsellingproduct.service.ProductService;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Component
public class ProductServiceImpl implements ProductService {
    SQLDB sqldb=SQLDB.getInstance();

    @Override
    public String getBestSellingProduct() {

        StringBuilder maxsellingProd = new StringBuilder();
        StringBuilder maxsellingByUser = new StringBuilder();
        int maxUsers=0;
        for(Map.Entry<String,ProductBean> prodEntry : sqldb.getProductDetailMap().entrySet()){
            ProductBean pb = prodEntry.getValue();
            Map<String, Integer> map = pb.getPurchasedByUsers();
            List<String> purchasedByUniqueUserList = new ArrayList<>();
            for(Map.Entry<String, Integer> e:map.entrySet()){
                String uid = e.getKey();
                if(sqldb.getBlackListedUserDetailsMap().get(uid)==null){
                    purchasedByUniqueUserList.add(uid);
                }
            }
            if(purchasedByUniqueUserList.size()>=maxUsers) {

                if(purchasedByUniqueUserList.size()>maxUsers){
                    maxUsers=purchasedByUniqueUserList.size();
                    maxsellingProd = new StringBuilder();
                    maxsellingProd.append(prodEntry.getKey());
                }else {
                    maxsellingProd.append(",").append(prodEntry.getKey());
                }
            }
        }
        return maxsellingProd+" was purchased "+maxUsers+" times";
    }
}
