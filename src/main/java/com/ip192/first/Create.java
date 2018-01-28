package com.ip192.first;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("try")
public class Create {

    @RequestMapping(value = "/success/{str}")
    public String firstTrySuccess(@PathVariable String str) {
        String res = "first try success? <br/>" + str;
        System.out.println(res);
        return res;
    }
}
