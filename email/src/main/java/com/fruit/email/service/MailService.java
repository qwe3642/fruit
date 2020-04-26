package com.fruit.email.service;

import com.fruit.email.common.RabbitConfig;
import com.fruit.email.dto.*;
import com.fruit.email.mapper.LogMapper;
import com.fruit.email.mapper.MailMapper;
import com.fruit.email.util.MailUtil;
import com.fruit.email.util.MessageHelper;
import com.fruit.email.util.RandomUtil;
import com.fruit.email.util.RedisUtil;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.rabbit.support.CorrelationData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MailService {

    @Autowired
    private MailMapper mapper;


    @Autowired
    private MailUtil mailUtil;

    public MailMapper getMapper(){
        return mapper;
    }
    public List<MailDto> queryByList(){
        return mapper.queryByList();
    }

    /**
     * 根据邮件id发送邮件
     * @param mailId
     */
    public ServerResponse sendMaill(String mailId){
        Mail mail=mailUtil.convertToMail(mailId);
        mailUtil.insertAndProduct(mail);
        return ServerResponse.success(ResponseCode.MAIL_SEND_SUCCESS.getMsg());
    }
}
