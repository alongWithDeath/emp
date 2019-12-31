package com.baizhi.service;

import com.baizhi.dao.UserDAO;
import com.baizhi.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;

/**
 * @ClassName UserServiceImpl
 * @Discription
 * @Author
 * @Date2019/11/11 17:05
 */
@Service
//@Transactional
public class UserServiceImpl implements UserService{
    @Autowired
    private UserDAO userDAO;

    public UserDAO getUserDAO() {
        return userDAO;
    }
    public void setUserDAO(UserDAO userDAO) {
        this.userDAO = userDAO;
    }

    @Override
    //事务    只读
    @Transactional(propagation = Propagation.SUPPORTS,readOnly = true)
    public List<User> showAll() {
        List<User> users = userDAO.queryAll();
        return users;
    }

    @Override
    public User login(String name,String password) {

        //HttpSession session = ServletActionContext.getRequest().getSession();

            User login = userDAO.loginUser(name);

            if(login == null){ throw new RuntimeException("用户名错误");}

            if(!login.getPassword().equals(password)) throw new RuntimeException("密码错误");
            //session.setAttribute("login",login);
            return login;


    }

    @Override
    public void registerUser(User user) {
        user.setId(UUID.randomUUID().toString());
        user.setRole("1");
        user.setStatus("0");
        userDAO.insertUser(user);
    }

    @Override
    public void updateUser(User user) {
        userDAO.updateUser(user);
    }

    @Override
    public void delete(String[] id) {
       userDAO.delete(id);
    }

    @Override
    public List<User> showLike(String key, String content) {
        System.out.println(key);
        Integer age =null;
        double salary =0;
        if(key.equals("age")){
            age = Integer.parseInt(content);
        }
        if(key.equals("salary")){
            salary = Double.parseDouble(content);
        }
        List<User> users = userDAO.queryLike(key,content,age,salary);
        return users;
    }
}
