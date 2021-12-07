/*
 * Copyright (c) 2016 BeiJing JZYT Technology Co. Ltd
 * www.idsmanager.com
 * All rights reserved.
 *
 * This software is the confidential and proprietary information of
 * BeiJing JZYT Technology Co. Ltd ("Confidential Information").
 * You shall not disclose such Confidential Information and shall use
 * it only in accordance with the terms of the license agreement you
 * entered into with BeiJing JZYT Technology Co. Ltd.
 */
package com.idsmanager.idp.auth.plugin.demo.service.dto;

import java.io.Serializable;

/**
 * 2020/11/10
 *
 * @author ilanyu
 */
public class LoginDto implements Serializable {

    private static final long serialVersionUID = 5449509395542483776L;

    private String username;

    private String password;

    private String enterpriseAuthId;

    private String traceId;

    public LoginDto() {
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEnterpriseAuthId() {
        return enterpriseAuthId;
    }

    public void setEnterpriseAuthId(String enterpriseAuthId) {
        this.enterpriseAuthId = enterpriseAuthId;
    }

    public String getTraceId() {
        return traceId;
    }

    public void setTraceId(String traceId) {
        this.traceId = traceId;
    }

    @Override
    public String toString() {
        return "LoginDto{" +
                "username='" + username + '\'' +
                ", password='***'" +
                ", enterpriseAuthId='" + enterpriseAuthId + '\'' +
                ", traceId='" + traceId + '\'' +
                '}';
    }
}
