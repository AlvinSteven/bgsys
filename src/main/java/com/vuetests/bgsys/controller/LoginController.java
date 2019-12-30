package com.vuetests.bgsys.controller;

import com.vuetests.bgsys.customer.User;
import com.vuetests.bgsys.result.Result;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.util.HtmlUtils;

import java.util.Objects;

@Controller
public class LoginController {

    @CrossOrigin
    @PostMapping(value = "api/login")
    @ResponseBody
    public Result login(@RequestBody User requestUser) {
        // 对 html 标签进行转义，防止 XSS 攻击
        String username = requestUser.getUsername();
        username = HtmlUtils.htmlEscape(username);

        if (!Objects.equals("admin", username) || !Objects.equals("123456", requestUser.getPassword())) {
            String message = "账号或密码错误";
            System.out.println(message + " --> username:" + username + ", password:" + requestUser.getPassword());
            return new Result(400);
        } else {
            return new Result(200);
        }
    }
}
