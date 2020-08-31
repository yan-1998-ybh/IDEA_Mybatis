package com.itybh.dao.imp;

import com.itybh.dao.IUserDao;
import com.itybh.domain.User;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import java.util.List;

public class UserDaoImpl implements IUserDao {
    private SqlSessionFactory factory;
    public UserDaoImpl(SqlSessionFactory factory){
        this.factory = factory;
    }
    @Override
    public List<User> findAll() {
//        1.根据factory获取SqlSession对象
        SqlSession sqlSession = factory.openSession();
//        2.调用SqlSession中的方法，实现查询列表
       List<User> users = sqlSession.selectList("com.itybh.dao.IUserDao.findAll");//参数就是能获得配置信息的key
//       3.释放资源
        sqlSession.close();
       return users;
    }

    @Override
    public void saveUser(User user) {
        //        1.根据factory获取SqlSession对象
        SqlSession sqlSession = factory.openSession();
        //        2.调用SqlSession中的方法，实现保存操作
        sqlSession.insert("com.itybh.dao.IUserDao.saveUser",user);
        //        3.提交事务
        sqlSession.commit();
        //        4.释放资源
        sqlSession.close();
    }

    @Override
    public void updateUser(User user) {
        //        1.根据factory获取SqlSession对象
        SqlSession sqlSession = factory.openSession();
        //        2.调用SqlSession中的方法，实现更新操作
        sqlSession.update("com.itybh.dao.IUserDao.updateUser",user);
        //        3.提交事务
        sqlSession.commit();
        //        4.释放资源
        sqlSession.close();

    }

    @Override
    public void deleteUser(Integer userSum) {
        //        1.根据factory获取SqlSession对象
        SqlSession sqlSession = factory.openSession();
        //        2.调用SqlSession中的方法，实现删除操作
        sqlSession.delete("com.itybh.dao.IUserDao.deleteUser",userSum);
        //        3.提交事务
        sqlSession.commit();
        //        4.释放资源
        sqlSession.close();
    }

    @Override
    public User findBySum(Integer userSum) {
        //        1.根据factory获取SqlSession对象
        SqlSession sqlSession = factory.openSession();
//        2.调用SqlSession中的方法，实现查询一个
        User users = sqlSession.selectOne("com.itybh.dao.IUserDao.findBySum",userSum);
//       3.释放资源
        sqlSession.close();
        return users;

    }

    @Override
    public List<User> findByName(String username) {
        //        1.根据factory获取SqlSession对象
        SqlSession sqlSession = factory.openSession();
//        2.调用SqlSession中的方法，实现模糊查询
        List<User> users = sqlSession.selectList("com.itybh.dao.IUserDao.findByName",username);
//       3.释放资源
        sqlSession.close();
        return users;
    }

    @Override
    public int findTotal() {
        //        1.根据factory获取SqlSession对象
        SqlSession sqlSession = factory.openSession();
//        2.调用SqlSession中的方法，实现总记录查询
       Integer count= sqlSession.selectOne("com.itybh.dao.IUserDao.findTotal");
//       3.释放资源
        sqlSession.close();
        return count;
    }
}
