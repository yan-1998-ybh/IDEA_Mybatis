package com.itybh.test;

import com.itybh.dao.IUserDao;
import com.itybh.domain.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.Date;
import java.util.List;

public class AnnotationCRUDTest {
    private InputStream in;
    private SqlSessionFactory factory;
    private SqlSession session;
    private IUserDao userDao;
    @Before
    public void init() throws Exception {
        in = Resources.getResourceAsStream("SqlMapConfig.xml");
        factory = new SqlSessionFactoryBuilder().build(in);
        session = factory.openSession();
        userDao = session.getMapper(IUserDao.class);
    }
    @After
    public void destroy() throws Exception {
        session.commit();
        session.close();
        in.close();
    }

    @Test
    public void testSave(){
        User user = new User();
        user.setUsername("mybatis annotation");
        user.setAddress("甘肃天水");

        userDao.saveUser(user);
    }

    @Test
    public void testUpdate(){
        User user = new User();
        user.setId(58);
        user.setUsername("mybatis annotation update");
        user.setAddress("甘肃天水麦积区");
        user.setSex("男");
        user.setBirthday(new Date());
        userDao.updateUser(user);
    }

    @Test
    public void testDelete(){
//        User user = new User();
//        user.setId(51);
//        userDao.deleteUser(user);
        userDao.deleteUser(50);
    }
    @Test
    public void testFindOne(){
        User user = userDao.findById(45);
        System.out.println(user);
    }

    @Test
    public void testFindByName(){
//       List<User> users = userDao.findByName("%王%");
        List<User> users = userDao.findByName("王");
       for (User user:users){
           System.out.println(user);
       }
    }

    @Test
    public void testFindTotal(){
        int total = userDao.findTotalUser();
        System.out.println(total);
    }
}
