package com.fruit.redis.action;

import com.fruit.redis.util.RedisUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/redis")
public class TestAction {
    @Autowired
    private RedisUtil redisUtil;

    @GetMapping("/getData")
    public Object getDateFromRedis(@RequestParam(value = "key")String id){
        return redisUtil.get(id);
    }

    @GetMapping("/setData")
    public Boolean setDateToRedis(@RequestParam(value = "key")String key,@RequestParam(value = "value")Object value){
        return redisUtil.set(key,value);
    }

}

