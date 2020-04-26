package com.fruit.email.mapper;

import com.fruit.email.dto.MailDto;

import java.util.List;

public interface MailMapper {

    public List<MailDto> queryByList();
}
