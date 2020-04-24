package com.fruit.client2.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Client2Controller {

    @RequestMapping("/getClient2")
    public String getClient2() {
        return "获取client2";
    }
}
