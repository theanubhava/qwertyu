package com.practice.bestsellingproduct.database;

import com.practice.bestsellingproduct.pojo.OrderBean;
import com.practice.bestsellingproduct.pojo.ProductBean;
import com.practice.bestsellingproduct.pojo.UserBean;

import java.util.HashMap;
import java.util.Map;

public class SQLDB {
    private static SQLDB sqldb = new SQLDB();

    private SQLDB() {
    }

    public static SQLDB getInstance() {
        return sqldb;
    }

    private Map<String, UserBean> activeUserDetailsMap = new HashMap<>();
    private Map<String, UserBean> blackListedUserDetailsMap = new HashMap<>();
    private Map<String, ProductBean> productDetailMap = new HashMap<>();
    private Map<String, OrderBean> orderDetailMap = new HashMap<>();

    public Map<String, UserBean> getActiveUserDetailsMap() {
        return activeUserDetailsMap;
    }

    public void setActiveUserDetailsMap(Map<String, UserBean> activeUserDetailsMap) {
        this.activeUserDetailsMap = activeUserDetailsMap;
    }

    public Map<String, UserBean> getBlackListedUserDetailsMap() {
        return blackListedUserDetailsMap;
    }

    public void setBlackListedUserDetailsMap(Map<String, UserBean> blackListedUserDetailsMap) {
        this.blackListedUserDetailsMap = blackListedUserDetailsMap;
    }

    public Map<String, ProductBean> getProductDetailMap() {
        return productDetailMap;
    }

    public void setProductDetailMap(Map<String, ProductBean> productDetailMap) {
        this.productDetailMap = productDetailMap;
    }

    public Map<String, OrderBean> getOrderDetailMap() {
        return orderDetailMap;
    }

    public void setOrderDetailMap(Map<String, OrderBean> orderDetailMap) {
        this.orderDetailMap = orderDetailMap;
    }

}
