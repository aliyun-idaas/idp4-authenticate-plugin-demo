package com.idsmanager.idp.auth.plugin.demo;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * 2020/11/12 12:47 PM
 *
 * @author Shengzhao Li
 */
public class DemoAuthenticateTest {


    @Test
    public void name() {

        DemoAuthenticate authenticate = new DemoAuthenticate();
        String name = authenticate.name();
        assertNotNull(name);
    }

}