package com.fruit.email.action;

import com.fruit.email.dto.Mail;
import com.fruit.email.dto.ServerResponse;
import com.fruit.email.service.TestServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.Errors;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/TestController")
@Slf4j
public class TestController {
    @Autowired
    private TestServiceImpl testService;

//    @ApiIdempotent
//    @PostMapping("testIdempotence")
//    public ServerResponse testIdempotence() {
//        return testService.testIdempotence();
//    }
//
//    @AccessLimit(maxCount = 5, seconds = 5)
//    @PostMapping("accessLimit")
//    public ServerResponse accessLimit() {
//        return testService.accessLimit();
//    }

//    @GetMapping("send")
//    public ServerResponse sendMail(@Validated Mail mail, Errors errors) {
//        if (errors.hasErrors()) {
//            String msg = errors.getFieldError().getDefaultMessage();
//            return ServerResponse.error(msg);
//        }
//
//        return testService.send(mail);
//    }

    @GetMapping("send")
    public ServerResponse sendMail() {
//        if (errors.hasErrors()) {
//            String msg = errors.getFieldError().getDefaultMessage();
//            return ServerResponse.error(msg);
//        }

        return testService.send();
    }
}
