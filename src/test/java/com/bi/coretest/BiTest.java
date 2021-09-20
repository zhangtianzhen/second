package com.bi.coretest;

import com.bi.controller.AccountController;
import com.bi.pojo.Transfer;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.HashMap;

/**
 * @Author 狗头军师@Yeah~2021
 * @Date 2021/9/9 22:10
 * @Version 1.0
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")
public class BiTest {

    @Autowired
    private AccountController controller;

    @Test
    public void test1(){
        controller.listAccounts();
    }
    @Test
    public void test2(){
        HashMap<String, Transfer> map = new HashMap<>();
        map.put("sender",new Transfer("张三",-1021));
        map.put("rejecter",new Transfer("李四",1021));
        controller.transfer(map);
    }
}
