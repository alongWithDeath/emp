package com.baizhi.test;

import com.baizhi.entity.User;
import com.baizhi.service.UserService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

/**
 * @ClassName Test3
 * @Discription
 * @Author
 * @Date2019/11/12 1:03
 */
public class Test3 {
    @Test
    public void test(){
        ApplicationContext context  = new ClassPathXmlApplicationContext("/spring-core.xml");
        UserService userService = (UserService)context.getBean("userService");
        List<User> users = userService.showLike("salary", "2000");
        System.out.println(users);

    }
}
