package com.fruit.email.service;

import com.fruit.email.dto.LogDto;
import com.fruit.email.dto.Mail;
import com.fruit.email.mapper.LogMapper;
import com.fruit.email.common.RabbitConfig;
import com.fruit.email.util.MessageHelper;
import com.fruit.email.util.RandomUtil;
import com.fruit.email.dto.ResponseCode;
import com.fruit.email.dto.ServerResponse;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.rabbit.support.CorrelationData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TestServiceImpl {
    @Autowired
    private LogMapper msgLogMapper;

    @Autowired
    private RabbitTemplate rabbitTemplate;

    public ServerResponse send() {
        Mail mail=new Mail();
        mail.setTo("364297143@qq.com");
        mail.setContent("正文");
        mail.setTitle("标题");
        String msgId = RandomUtil.UUID32();
        mail.setMsgId(msgId);

        LogDto msgLog = new LogDto(msgId, mail, RabbitConfig.MAIL_EXCHANGE_NAME, RabbitConfig.MAIL_ROUTING_KEY_NAME);
        msgLogMapper.insert(msgLog);// 消息入库

        CorrelationData correlationData = new CorrelationData(msgId);
        rabbitTemplate.convertAndSend(RabbitConfig.MAIL_EXCHANGE_NAME, RabbitConfig.MAIL_ROUTING_KEY_NAME, MessageHelper.objToMsg(mail), correlationData);// 发送消息

        return ServerResponse.success(ResponseCode.MAIL_SEND_SUCCESS.getMsg());
    }
}
