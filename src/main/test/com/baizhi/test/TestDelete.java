package com.baizhi.test;

import com.baizhi.service.UserService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @ClassName TestDelete
 * @Discription
 * @Author
 * @Date2019/11/13 19:43
 */

public class TestDelete {
    @Test
    public void test(){
        ApplicationContext context = new ClassPathXmlApplicationContext("/spring-core.xml");
        UserService userService = (UserService)context.getBean("userServiceImpl");
        String[] id ={"2","3"};
        userService.delete(id);
    }
}
