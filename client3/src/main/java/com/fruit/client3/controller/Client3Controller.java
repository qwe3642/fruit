package com.fruit.client3.controller;


import com.fruit.client3.ClientInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Client3Controller {
    @Autowired
    private ClientInterface clientInterface;

    @RequestMapping("/getClient3")
    public String getProduct() {
        return clientInterface.getClient2();
    }
}
