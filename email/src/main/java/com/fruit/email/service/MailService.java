package com.fruit.email.service;

import com.fruit.email.common.RabbitConfig;
import com.fruit.email.dto.*;
import com.fruit.email.mapper.LogMapper;
import com.fruit.email.mapper.MailMapper;
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
    private RedisUtil redisUtil;
    @Autowired
    private LogMapper msgLogMapper;
    @Autowired
    private RabbitTemplate rabbitTemplate;

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
        MailDto mailDto=(MailDto)redisUtil.get(mailId);
        List<MailCsrDto> mailCsrDtos=mailDto.getCsrDtoList();
        List<MailSjrDto> mailSjrDtos=mailDto.getSjrDtoList();
        String [] csr=new String[mailCsrDtos.size()];
        String [] sjr=new String[mailSjrDtos.size()];
        for(int i = 0;i < mailCsrDtos.size();i++){
            csr[i]=mailCsrDtos.get(i).getMaillAddress();
        }
        for(int i = 0;i < mailCsrDtos.size();i++){
            sjr[i]=mailSjrDtos.get(i).getMaillAddress();
        }
        Mail mail=new Mail();
        mail.setToArray(sjr);
        mail.setCsrArray(csr);
        mail.setContent(mailDto.getNr());
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
