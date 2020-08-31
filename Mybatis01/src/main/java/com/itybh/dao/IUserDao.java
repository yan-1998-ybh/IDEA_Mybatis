package com.itybh.dao;

import com.itybh.domain.QueryVo;
import com.itybh.domain.User;

import java.util.List;

/*
* 用户的持久层接口
* */
public interface IUserDao {

    /*
    * 查询所有操作
    * */
    List<User> findAll();
    /*
    * 保存用户
    * */
    void saveUser(User user);
    /*
    * 更新用户
    * */
    void updateUser(User user);
    /*
    * 根据Snum删除用户
    * */
    void deleteUser(Integer userSum);
    /*
     * 根据Snum查询用户信息
     * */
    User findBySum(Integer userSum);
    /*
    * 根据名称模糊查询用户信息
    * */
    List<User> findByName(String username);
    /*
    * 查询总用户数
    * */
    int findTotal();
    /*
    *根据queryVo中的条件查询用户
    * */
    List<User> findUserByVo(QueryVo vo);
}
