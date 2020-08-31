package com.itybh.dao;

import com.itybh.domain.User;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;
/**
 *在mybatis中针对，CRUD一共有四个注解
 * @Select @Insert @Update @Delete
 */


public interface IUserDao {
    /**
     * 查询所有用户
     * @return
     */
    @Select("select * from user")
    List<User> findAll();

    /**
     *保存用户
     * @param user
     */
    @Insert("insert into user(username,address,sex,birthday)values(#{username},#{address},#{sex},#{birthday})")
    void saveUser(User user);

    /**
     * 更新用户信息
     * @param user
     */
    @Update("update user set username=#{username},sex=#{sex},birthday=#{birthday},address=#{address} where id=#{id}")
    void updateUser(User user);

    /**
     * 删除信息
     * @param user userId
     */
    @Delete("delete from user where id=#{id} ")
//    void deleteUser(User user);
      void deleteUser(Integer userId);

    /**
     * 根据ID查询用户
     * @param userId
     * @return
     */
    @Select("select *from user where id=#{id}")
    User findById(Integer userId);

    /**
     * 根据用户名称模糊查询
     * @param username
     * @return
     */
//    @Select("select * from  user where username like #{username}")
    @Select("select * from  user where username like '%${value}%'")
    List<User> findByName(String username);

    /**
     * 查询总用户数
     * @return
     */
    @Select("select count(*) from user ")
    int findTotalUser();
}
