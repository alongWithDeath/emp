package com.baizhi.test;

import com.baizhi.entity.User;
import com.baizhi.service.UserService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @ClassName Test2
 * @Discription
 * @Author
 * @Date2019/11/11 23:34
 */
public class Test2 {
    @Test
    public void test1(){
        ApplicationContext context = new ClassPathXmlApplicationContext("/spring-core.xml");
        UserService userService = (UserService)context.getBean("userService");
        User user = new User();
        user.setName("李四");
        user.setAge(18);
        user.setSalary(3000);
        user.setId("2");
        userService.updateUser(user);
    }

    @Test
    public void test2(){
        ApplicationContext context = new ClassPathXmlApplicationContext("/spring-core.xml");
        UserService userService = (UserService)context.getBean("userService");
        User user = new User();
        user.setStatus("1");
        user.setId("2");
     //   userService.delete(user);
    }


}
