package com.fruit.email.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.apache.ibatis.annotations.ConstructorArgs;

import java.util.List;

/**
 * 邮件dto
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class MailDto {
    private String id;

    private String code;

    private String name;

    private String title;

    private String nr;

    private String cs;

    private List<MailCsrDto> csrDtoList;

    private List<MailSjrDto> sjrDtoList;

}
