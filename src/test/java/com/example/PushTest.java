/**
 * Copyright(c) 2004-2018 by qyer.com All rights reserved.
 */
package com.example;

import java.text.ParseException;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.gexin.rp.sdk.base.IPushResult;
import com.gexin.rp.sdk.exceptions.PushAppException;

/**
 * @author Tony
 * @date 2018-03-10
 * @version 1.0
 */
public class PushTest {

    /**
     * @throws java.lang.Exception
     */
    @BeforeClass
    public static void setUpBeforeClass() throws Exception {
    }

    /**
     * @throws java.lang.Exception
     */
    @AfterClass
    public static void tearDownAfterClass() throws Exception {
    }

    /**
     * @throws java.lang.Exception
     */
    @Before
    public void setUp() throws Exception {
    }

    /**
     * @throws java.lang.Exception
     */
    @After
    public void tearDown() throws Exception {
    }

    /**
     * Test method for
     * {@link com.example.Push#push4Android(java.lang.String, java.lang.String, java.lang.String)}.
     */
    @Test
    public void testPush4Android() {
        IPushResult result = null;
        try {
            result = Push.push4Android("test title", "test text",
                "http://www.baidu.com");
            System.out.println(result.getResponse().toString());
        } catch (PushAppException | ParseException e) {
            e.printStackTrace();
        }
    }

    /**
     * Test method for
     * {@link com.example.Push#push4AndroidByTime(java.lang.String, java.lang.String, java.lang.String, java.lang.String)}.
     */
    @Test
    public void testPush4AndroidByTime() {
        IPushResult result = null;
        try {
            result = Push.push4AndroidByTime("test time title",
                "test time text", "http://www.baidu.com", "201803101630");
            System.out.println(result.getResponse().toString());
        } catch (PushAppException | ParseException e) {
            e.printStackTrace();
        }
    }

}
