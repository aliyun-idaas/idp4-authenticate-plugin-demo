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
package com.idsmanager.idp.auth.plugin.demo.service;

import com.idsmanager.idp.auth.plugin.demo.service.dto.LoginDto;
import com.idsmanager.idp.auth.plugin.demo.service.dto.LoginResult;

/**
 * 2020/11/4
 *
 * @author ilanyu
 */
public interface DemoService {
    LoginResult handleLogin(LoginDto dto);
}
