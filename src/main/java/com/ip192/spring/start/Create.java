package com.ip192.spring.start;

import com.ip192.spring.accessToken.Login;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("try")
public class Create {

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
}
