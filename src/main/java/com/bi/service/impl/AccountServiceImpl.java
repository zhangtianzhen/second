package com.bi.service.impl;

import com.bi.anno.Auth;
import com.bi.dao.AccountDao;
import com.bi.pojo.Account;
import com.bi.pojo.Transfer;
import com.bi.service.AccountService;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;

/**
 * @Author 狗头军师@Yeah~2021
 * @Date 2021/9/9 21:42
 * @Version 1.0
 */

@Service
public class AccountServiceImpl implements AccountService {

    @Autowired
    private AccountDao accountDao;

    @Auth(username = "admin1234",password = "admin1234")
    @Override
    public void transaction(HashMap<String, Transfer> map) {
        Transfer sender = map.get("sender");
        Transfer rejecter = map.get("rejecter");
        //转账
        accountDao.updateAccount(sender);

        accountDao.updateAccount(rejecter);
        System.out.println("transer success");
    }

    @Auth(username = "admin",password = "admin")
    @Override
    public List<Account> listAccount() {
        return accountDao.listAccount();
    }


}
