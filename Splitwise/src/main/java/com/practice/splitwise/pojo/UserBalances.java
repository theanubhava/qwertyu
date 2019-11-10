package com.practice.splitwise.pojo;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class UserBalances {
    List<Map<String,Double>> collectFrom;
    List<Map<String,Double>> payTo;

    public List<Map<String, Double>> getCollectFrom() {
        if(collectFrom==null)
            collectFrom=new ArrayList<>();
        return collectFrom;
    }

    public void setCollectFrom(List<Map<String, Double>> collectFrom) {
        this.collectFrom = collectFrom;
    }

    public List<Map<String, Double>> getPayTo() {
        if(payTo==null)
            payTo=new ArrayList<>();
        return payTo;
    }

    public void setPayTo(List<Map<String, Double>> payTo) {
        this.payTo = payTo;
    }
}
