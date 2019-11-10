package com.practice.bestsellingproduct.controller;

import com.practice.bestsellingproduct.pojo.PurchaseRequestHolder;
import com.practice.bestsellingproduct.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/order")
public class OrderController {

    @Autowired
    OrderService orderService;


    @RequestMapping(value = "/purchase", method = RequestMethod.POST)
    public String purchaseOrder(@RequestBody List<PurchaseRequestHolder> purchaseRequestHolderList ) {
        String res = orderService.purchaseOrder(purchaseRequestHolderList);
        System.out.println(res);
        return  res;
    }

    @RequestMapping(value = "/return", method = RequestMethod.POST)
    public String returnOrder(@RequestBody List<PurchaseRequestHolder> purchaseRequestHolderList) {
        String res = orderService.returnOrder(purchaseRequestHolderList);
        System.out.println(res);
        return  res;
    }

}
