package com.vuetests.bgsys.controller;

import com.vuetests.bgsys.customer.User;
import com.vuetests.bgsys.result.Result;
import com.vuetests.bgsys.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.util.HtmlUtils;

import java.util.Objects;

@Controller
public class LoginController {
    @Autowired
    UserService userService;

    @CrossOrigin
    @PostMapping(value = "api/login")
    @ResponseBody
    public Result login(@RequestBody User requestUser) {
        // 对 html 标签进行转义，防止 XSS 攻击
        String username = requestUser.getUsername();
        username = HtmlUtils.htmlEscape(username);

        User user = userService.get(username, requestUser.getPassword());
       /* if (!Objects.equals("admin", username) || !Objects.equals("123456", requestUser.getPassword())) {
            String message = "账号或密码错误";
            System.out.println(message + " --> username:" + username + ", password:" + requestUser.getPassword());
            return new Result(400);
        } else {
            return new Result(200);
        }*/
        if (null == user) {
            String message = "账号或密码错误";
            System.out.println(message + " --> username:" + username + ", password:" + requestUser.getPassword());
            return new Result(400);
        } else {
            System.out.println("用户名-密码存在 --> User:" + user.toString());
            return new Result(200);
        }
    }
}
