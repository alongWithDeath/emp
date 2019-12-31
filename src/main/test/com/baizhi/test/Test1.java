package com.baizhi.test;

import com.baizhi.entity.User;
import com.baizhi.service.UserService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

/**
 * @ClassName Test1
 * @Discription
 * @Author
 * @Date2019/11/11 17:06
 */
public class Test1 {
    @Test
    public void test(){
        //读取spring配置信息
        ApplicationContext context = new ClassPathXmlApplicationContext("/spring-core.xml");
        UserService userService = (UserService)context.getBean("userServiceImpl");
        List<User> users = userService.showAll();
        for (User user:users){
            System.out.println(user);
        }
    }

    @Test
    public void test1(){
        //读取spring配置信息
        ApplicationContext context = new ClassPathXmlApplicationContext("/spring-core.xml");
        UserService userService = (UserService)context.getBean("userServiceImpl");
       try {
           User user = userService.login("张三1","123456");
           System.out.println(user);
       }catch (Exception e){
           e.printStackTrace();
       }

    }
    @Test
    public void test2(){
        //读取spring配置信息
        ApplicationContext context = new ClassPathXmlApplicationContext("/spring-core.xml");
        UserService userService = (UserService)context.getBean("userService");
        try {
            User user = new User();
            user.setName("王五");
            user.setPassword("123456");
            user.setAge(18);
            user.setSalary(2000);
            userService.registerUser(user);
            System.out.println(user);
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
