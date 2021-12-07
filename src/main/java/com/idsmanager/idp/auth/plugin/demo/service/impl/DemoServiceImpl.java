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
package com.idsmanager.idp.auth.plugin.demo.service.impl;

import com.idsmanager.idp.auth.plugin.demo.service.DemoService;
import com.idsmanager.idp.auth.plugin.demo.service.buiness.LoginHandler;
import com.idsmanager.idp.auth.plugin.demo.service.dto.LoginDto;
import com.idsmanager.idp.auth.plugin.demo.service.dto.LoginResult;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * 2020/11/4
 *
 * @author ilanyu
 */
@Service
public class DemoServiceImpl implements DemoService {

    @Override
    @Transactional
    public LoginResult handleLogin(LoginDto dto) {
        LoginHandler handler = new LoginHandler(dto);
        return handler.handle();
    }
}
