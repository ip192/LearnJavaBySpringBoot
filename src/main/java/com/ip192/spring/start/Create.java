package com.ip192.spring.start;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("try")
public class Create {

    @RequestMapping(value = "/success/{str}")
    public String firstTrySuccess(@PathVariable String str) {
        String res = "firstTry try success? <br/>" + str;
        System.out.println(res);
        return res;
    }
}
