package com.ip192.spring.accessToken;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@ResponseBody
@RestController
@RequestMapping(value = "access-token")
public class LoginController {
    @Autowired
    LoginService loginService;

    @RequestMapping(value = "/get-all", method = RequestMethod.GET)
    public List<Login> getAllLogin() {
        return loginService.getAll();
    }
}
