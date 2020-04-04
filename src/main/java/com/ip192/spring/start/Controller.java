package com.ip192.spring.start;

import com.ip192.spring.accessToken.Login;
import com.ip192.spring.service.ScopeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Map;

/**
 * 当controller和service都使用prototype方式声明时 原型模式生效
 * 每次请求访问会对应新的controller和service实例
 */
//@Scope("prototype")
@RestController
@RequestMapping("try")
public class Controller {
    private Integer count = 0;
    @Autowired
    private ScopeService scopeService;


    @RequestMapping(value = "/success/{str}")
    public String firstTrySuccess(@PathVariable String str) {
        String res = "firstTry try success? <br/>" + str;
        System.out.println(res);
        return res;
    }

    @ResponseBody
    @RequestMapping(value = "/success", method = RequestMethod.POST)
    public String secondTrySuccess(@RequestParam("str") String str) {
        String res = "secondTry try success? <br/>" + str;
        System.out.println(res);
        return res;
    }

    @RequestMapping(value = "post-data", method = RequestMethod.POST)
    public Object returnSelf(@RequestBody Map<String, Object> obj) {
        System.out.println(obj);

        return obj;
    }

    @RequestMapping(value = "login", method = RequestMethod.POST)
    public Object convertToObj(@RequestBody Login login) {
        System.out.println(login);

        return login;
    }

//    @PostMapping("mapping-test")
    @GetMapping("mapping-test")
    public String mappingTest(@RequestParam String param) {

        return param;
    }

    @GetMapping("singleton/scope")
    public void singletonScope() {
        this.count++;
        System.out.println("controller count: " + this.count);
        scopeService.scopeTry();
    }

    @GetMapping("redirect")
    public void redirectUrl(HttpServletResponse response) throws IOException {
        /**
         * redirect是间接转发，重定向   forward是直接转发，像代理请求
         */
        response.sendRedirect("singleton/scope");
    }
}
