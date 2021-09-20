package com.bi.controller;

import com.bi.pojo.Account;
import com.bi.pojo.Transfer;
import com.bi.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.util.HashMap;

/**
 * @Author 狗头军师@Yeah~2021
 * @Date 2021/9/9 21:25
 * @Version 1.0
 */
@Controller
public class AccountController {
    @Autowired
    private AccountService accountService;

    public void listAccounts(){
        for (Account account : accountService.listAccount()) {
            System.out.println(account);
        }
    }

    public void transfer(HashMap<String, Transfer> map){
        accountService.transaction(map);
    }
}
