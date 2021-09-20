package com.bi.dao;

import com.bi.pojo.Account;
import com.bi.pojo.Transfer;

import java.util.HashMap;
import java.util.List;

/**
 * @Author 狗头军师@Yeah~2021
 * @Date 2021/9/9 21:26
 * @Version 1.0
 */
public interface AccountDao {
    public void updateAccount(Transfer transfer);

    public List<Account> listAccount();

}
