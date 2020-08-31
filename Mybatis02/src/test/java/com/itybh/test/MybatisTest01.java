package com.itybh.test;

import com.itybh.dao.IUserDao;
import com.itybh.dao.imp.UserDaoImpl;
import com.itybh.domain.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;


import java.io.InputStream;
import java.util.List;

/*
* 测试mybatis的crud操作
* */
public class MybatisTest01 {
    private InputStream in;
    private  IUserDao userDao;
    @Before//用于测试方法执行之前执行
    public void init()throws Exception{
        //  1.读取配置文件，生成字节字节输入流
        in = Resources.getResourceAsStream("SqlMapConfig.xml");
        //           2.获取SqlSessionFactory
        SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(in);
        //           3.使用工厂对象，创建dao对象
        userDao = new UserDaoImpl(factory);
    }
    @After//用于测试方法执行之后执行
    public void destroy()throws Exception{
        in.close();
    }
    /*
    * 测试所有查询
    * */
    @Test
    public void testFindAll()  {

//       5.执行查询所有方法
       List<User> users = userDao.findAll();
       for(User user:users){
            System.out.println(user);
        }

    }
    /*
    * 测试保存操作
    * */
    @Test
    public void testSave()  {
        User user = new User();
        user.setUsername("mybatis gaibian ");
        user.setPassword("1234");
        user.setBalance(9999);
        System.out.println("保存操作之前"+user);

//       5.执行保存方法
        userDao.saveUser(user);
        System.out.println("保存操作之后"+user);

    }
    /*
     * 测试更新操作
     * */
    @Test
    public void testUpdate() {
        User user = new User();
        user.setSnum(10);
        user.setUsername("yanbohu");
        user.setPassword("11111");
        user.setBalance(8888);

//       5.执行更新方法
        userDao.updateUser(user);
    }
    /*
     * 测试更新操作
     * */
    @Test
    public void testDelete() {

//       5.执行删除方法
        userDao.deleteUser(2);
    }
    @Test
    public void testFindOne() {

//       5.执行查询一个方法
        User user = userDao.findBySum(3);
        System.out.println(user);
    }
    @Test
    public void testFindByName() {

//       5.执行查询一个根据username方法
        List<User> users = userDao.findByName("%大%");
//        List<User> users = userDao.findByName("大");
        for(User u :users){
            System.out.println(u);
        }

    }
    @Test
    public void testFindTotal() {

//       5.执行查询用户总记录条数方法
        int count = userDao.findTotal();
        System.out.println("总记录条数"+count+"条");
    }

}
