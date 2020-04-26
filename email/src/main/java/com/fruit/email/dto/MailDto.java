package com.fruit.email.dto;

import java.util.List;

/**
 * 邮件dto
 */
public class MailDto {
    private String id;

    private String code;

    private String name;

    private String nr;

    private String cs;

    private List<MailCsrDto> csrDtoList;

    private List<MailSjrDto> sjrDtoList;

    public List<MailCsrDto> getCsrDtoList() {
        return csrDtoList;
    }

    public void setCsrDtoList(List<MailCsrDto> csrDtoList) {
        this.csrDtoList = csrDtoList;
    }

    public List<MailSjrDto> getSjrDtoList() {
        return sjrDtoList;
    }

    public void setSjrDtoList(List<MailSjrDto> sjrDtoList) {
        this.sjrDtoList = sjrDtoList;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNr() {
        return nr;
    }

    public void setNr(String nr) {
        this.nr = nr;
    }

    public String getCs() {
        return cs;
    }

    public void setCs(String cs) {
        this.cs = cs;
    }
}
