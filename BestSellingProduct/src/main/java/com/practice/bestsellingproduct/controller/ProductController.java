package com.practice.bestsellingproduct.controller;

import com.practice.bestsellingproduct.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/product")
public class ProductController {

    @Autowired
    ProductService productService;


    @RequestMapping(value = "/bestselling", method = RequestMethod.GET)
    public String blackListUser() {
        String res = productService.getBestSellingProduct();
        System.out.println(res);
        return  res;
    }

}
