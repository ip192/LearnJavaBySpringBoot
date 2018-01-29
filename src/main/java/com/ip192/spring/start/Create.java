package com.ip192.spring.start;

import org.springframework.web.bind.annotation.*;

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
    @RequestMapping(value = "/success")
    public String secondTrySuccess(@RequestParam String str) {
        String res = "secondTry try success? <br/>" + str;
        System.out.println(res);
        return res;
    }
}
