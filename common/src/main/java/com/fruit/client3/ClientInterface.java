package com.fruit.client3;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;

@FeignClient(name = "product-server", path = "/product")
public interface ClientInterface {
    @RequestMapping(value = "getClient2")
    public String getClient2();
}
