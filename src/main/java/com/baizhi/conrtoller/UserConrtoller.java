package com.baizhi.conrtoller;

import com.baizhi.entity.User;
import com.baizhi.service.UserService;
import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;


/**
 * @ClassName UserConrtoller
 * @Discription
 * @Author
 * @Date2019/11/13 20:28
 */
@Controller
@RequestMapping("user")
public class UserConrtoller {
    @Autowired
    private UserService userService;

    @RequestMapping("showAll")
    public String showAll(HttpServletResponse response){
        response.setCharacterEncoding("utf-8");
        List<User> users = userService.showAll();
        //获取流
        try {
            PrintWriter out = response.getWriter();
            //转化
            Gson gson = new Gson();
            String s = gson.toJson(users);
            out.println(s);
        } catch (IOException e) {
            e.printStackTrace();
        }
       return null;
    }

    @RequestMapping("delete")
    public String deleteMethod(String[] id){
        System.out.println("------进入了---------");
         userService.delete(id);
      return "redirect:/emplist.jsp";
    }

    @RequestMapping("update")
    public String update(User user){
        userService.updateUser(user);
        return "redirect:/emplist.jsp";
    }

    @RequestMapping("register")
    public String register(User user){
        userService.registerUser(user);
        return "redirect:/emplist.jsp";
    }

    @RequestMapping("showLike")
    public String showLike(String key, String content, ModelMap model){
        List<User> users = userService.showLike(key, content);
        model.addAttribute("users",users);
        //request.setAttribute("users",users);
        return "/emplist.jsp";
    }

}
