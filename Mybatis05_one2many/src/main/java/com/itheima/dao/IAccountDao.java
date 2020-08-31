package com.itheima.dao;

import com.itheima.domain.Account;
import com.itheima.domain.AccountUser;


import java.util.List;

public interface IAccountDao {
    /**
     * 查询所有账户，同时还要获取到当前帐户所属的用户信息
     * @return
     */
    List<Account> findAll();


    /**
     * 查询所有账户，并且带有用户名称和地址信息
     * @param
     * @return
     */
    List<AccountUser> findAllAccount();
}
