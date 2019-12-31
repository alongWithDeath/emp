package com.baizhi.conrtoller;

import com.baizhi.entity.User;
import com.baizhi.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import javax.servlet.http.HttpServletRequest;

/**
 * @ClassName UserLoginConrtoller
 * @Discription
 * @Author
 * @Date2019/11/13 20:48
 */
@Controller
//这相当于 struts.xml中的namspace
@RequestMapping("userlogin")
@SessionAttributes({"login"})
public class UserLoginConrtoller {
    @Autowired
    UserService userService;

    public UserService getUserService() {
        return userService;
    }
    public void setUserService(UserService userService) {
        this.userService = userService;
    }
    @RequestMapping("login")
    public String login(Model mode, User user, HttpServletRequest request){
        try {
            User login1 = userService.login(user.getName(), user.getPassword());
            mode.addAttribute("login",login1);
            //session.setAttribute("login",login1);
            return "redirect:/emplist.jsp";
        }catch(Exception e){
            String message = e.getMessage();
            System.out.println(message);
            request.setAttribute("message",message);
            return "forward:/login.jsp";
        }
    }
}
