package com.bi.service;

import com.bi.pojo.Account;
import com.bi.pojo.Transfer;

import java.util.HashMap;
import java.util.List;

/**
 * @Author 狗头军师@Yeah~2021
 * @Date 2021/9/9 21:26
 * @Version 1.0
 */
public interface AccountService {

    public void transaction(HashMap<String, Transfer>  map);
    public List<Account> listAccount();
}
