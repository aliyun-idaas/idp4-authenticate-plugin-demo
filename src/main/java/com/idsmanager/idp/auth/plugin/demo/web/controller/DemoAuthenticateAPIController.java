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
package com.idsmanager.idp.auth.plugin.demo.web.controller;

import com.idsmanager.idp.auth.plugin.demo.DemoAuthenticate;
import com.idsmanager.idp.auth.plugin.demo.service.DemoService;
import com.idsmanager.idp.auth.plugin.demo.service.dto.LoginDto;
import com.idsmanager.idp.auth.plugin.demo.service.dto.LoginResult;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 2020/10/19
 *
 * @author ilanyu
 */
@RestController
@RequestMapping("/public/api/authenticate/" + DemoAuthenticate.AUTH_ID)
public class DemoAuthenticateAPIController {

    private static final Logger LOG = LoggerFactory.getLogger(DemoAuthenticateAPIController.class);

    @Autowired
    private DemoService service;

    @PostMapping("/login")
    public LoginResult getInfo(@RequestBody LoginDto dto) {
        return service.handleLogin(dto);
    }
}
