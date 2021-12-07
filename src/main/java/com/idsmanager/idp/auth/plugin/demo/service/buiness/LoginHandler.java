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
package com.idsmanager.idp.auth.plugin.demo.service.buiness;

import com.idsmanager.idp.auth.core.AdapterPluginBeanProvider;
import com.idsmanager.idp.auth.core.domain.EnterpriseAuthenticateRepository;
import com.idsmanager.idp.auth.core.dto.IDPAdapterTraceIDDto;
import com.idsmanager.idp.auth.plugin.demo.service.dto.LoginDto;
import com.idsmanager.idp.auth.plugin.demo.service.dto.LoginResult;
import com.idsmanager.micro.commons.web.filter.RIDHolder;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 2020/11/10
 *
 * @author ilanyu
 */
public class LoginHandler {

    private static final Logger LOG = LoggerFactory.getLogger(LoginHandler.class);

    private transient EnterpriseAuthenticateRepository authenticateRepository = AdapterPluginBeanProvider.getBean(EnterpriseAuthenticateRepository.class);

    private LoginDto dto;

    public LoginHandler(LoginDto dto) {
        this.dto = dto;
    }

    public LoginResult handle() {
        final IDPAdapterTraceIDDto traceIDDto = authenticateRepository.findIDPAdapterTraceIDDto(dto.getTraceId());
        if (traceIDDto == null) {
            LOG.warn("[{}]- Not found the traceId[{}]", RIDHolder.id(), dto.getTraceId());
            return new LoginResult("traceId.error");
        }

        if (!"admin".equals(dto.getUsername()) || !"password".equals(dto.getPassword())) {
            LOG.debug("[{}]- Username[{}] or password[length={}] error", RIDHolder.id(), dto.getUsername(), StringUtils.length(dto.getPassword()));
            return new LoginResult("username.or.password.error");
        }

        traceIDDto.setAuthSuccess(true);
        traceIDDto.setOpenId(dto.getUsername());
        traceIDDto.setUsername(dto.getUsername());
        traceIDDto.setMail(dto.getUsername() + "@idsmanager.com");

        authenticateRepository.updateIDPAdapterTraceIDDto(traceIDDto);

        final String frontendAdapterAddress = authenticateRepository.frontendAdapterAddress();
        final LoginResult loginResult = new LoginResult();
        loginResult.setSuccess(true);
        loginResult.setFrontendAdapterAddress(frontendAdapterAddress);
        LOG.debug("[{}]- Username[{}] login success", RIDHolder.id(), dto.getUsername());
        return loginResult;
    }
}
