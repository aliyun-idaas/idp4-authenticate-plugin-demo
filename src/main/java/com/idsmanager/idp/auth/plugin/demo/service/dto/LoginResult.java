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
public class LoginResult implements Serializable {

    private static final long serialVersionUID = -1188031078226260287L;

    private boolean success;

    private String msg;

    private String frontendAdapterAddress;

    public LoginResult() {
    }

    public LoginResult(String msg) {
        this.success = false;
        this.msg = msg;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public String getFrontendAdapterAddress() {
        return frontendAdapterAddress;
    }

    public void setFrontendAdapterAddress(String frontendAdapterAddress) {
        this.frontendAdapterAddress = frontendAdapterAddress;
    }

    @Override
    public String toString() {
        return "LoginResult{" +
                "success=" + success +
                ", msg='" + msg + '\'' +
                ", frontendAdapterAddress='" + frontendAdapterAddress + '\'' +
                '}';
    }
}
