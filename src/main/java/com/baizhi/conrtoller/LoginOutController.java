package com.baizhi.conrtoller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;

/**
 * @ClassName LoginOutController
 * @Discription
 * @Author
 * @Date2019/11/14 19:12
 */
@Controller
@RequestMapping("/loginout")
public class LoginOutController {
    @RequestMapping("/out")
    public  String loginOut(HttpSession session){
        session.invalidate();
        return "redirect:/login.jsp";
    }
}
