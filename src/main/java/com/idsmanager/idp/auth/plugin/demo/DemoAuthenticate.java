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
package com.idsmanager.idp.auth.plugin.demo;

import com.idsmanager.idp.auth.core.IDPAuthenticateAdapter;
import com.idsmanager.idp.auth.core.domain.ClientDevice;
import com.idsmanager.micro.commons.web.filter.RIDHolder;
import org.apache.commons.io.IOUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

/**
 * 2020/10/19
 *
 * @author ilanyu
 */
public class DemoAuthenticate extends IDPAuthenticateAdapter {

    private static final Logger LOG = LoggerFactory.getLogger(DemoAuthenticate.class);


    public static final String NAME = "Demo";
    public static final String AUTH_ID = "plugin_demo";

    private byte[] logoAsBytes;

    public DemoAuthenticate() {
    }

    public String name() {
        return NAME;
    }

    @Override
    public String description() {
        return "使用 Demo 登录";
    }

    public String authId() {
        return AUTH_ID;
    }

    @Override
    public boolean customLogin() {
        return true;
    }

    @Override
    public boolean plugin() {
        return true;
    }

    @Override
    public long pluginVersion() {
        return 1;
    }

    @Override
    public long dependencyMinCoreVersion() {
        return 1;
    }

    /**
     * 设定认证源支持的终端设备，可选 有：
     * PC_BROWSER  ,  PC浏览器
     * MOBILE_H5  , 移动端H5
     * <p>
     * 默认  PC_BROWSER；具体由认证源支持情况决定
     * (如扫码类，证书类不能在移动端H5上使用)
     *
     * @return ClientDevice List
     * @since 1.1
     */
    @Override
    public List<ClientDevice> supportClientDevices() {
        return Arrays.asList(
                ClientDevice.PC_BROWSER
        );
    }

    @Override
    public String loginUrl(String enterpriseAuthId) {
        return "/public/api/authenticate/" + AUTH_ID + "/login_" + enterpriseAuthId;
    }

    public String enableApplicationUrl(String enterpriseAuthId, boolean enable) {
        return "/enterprise/authenticate/" + AUTH_ID + "/" + (enable ? "enable_" : "disable_") + enterpriseAuthId;
    }

    public String detailsUrl(String enterpriseAuthId) {
        return "/enterprise/authenticate/" + AUTH_ID + "/details_" + enterpriseAuthId;
    }

    public String configUrl(String enterpriseId) {
        return "/enterprise/authenticate/" + AUTH_ID + "/config_" + enterpriseId;
    }

    public byte[] logoAsBytes() throws IOException {
        if (this.logoAsBytes == null) {
            this.logoAsBytes = IOUtils.toByteArray(this.getClass().getClassLoader().getResourceAsStream("demo.png"));
            LOG.debug("[{}]- Initialed Authenticate logo from: demo.png", RIDHolder.id());
        }
        return this.logoAsBytes;
    }

    @Override
    public String bindingUrl(String enterpriseAuthId) {
        return "/enduser/authenticate/" + AUTH_ID + "/binding_" + enterpriseAuthId;
    }

    @Override
    public String unBoundUrl(String enterpriseAuthId) {
        return "/enduser/authenticate/" + AUTH_ID + "/unbond_" + enterpriseAuthId;
    }

    @Override
    public String modifyUrl(String enterpriseAuthId) {
        return "/enterprise/authenticate/" + AUTH_ID + "/modify_" + enterpriseAuthId;
    }
}
