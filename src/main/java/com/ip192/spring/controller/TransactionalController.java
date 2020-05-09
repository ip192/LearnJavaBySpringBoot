package com.ip192.spring.controller;

import com.ip192.spring.entity.User;
import com.ip192.spring.mapper.UserMapper;
import com.ip192.spring.service.executors.BusinessOneAsyncTask;
import com.ip192.spring.service.transactionals.TransactionInvokeOneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


/**
 * 使用Controller注解通常是要返回model and view
 * 若要返回json string 需在返回类型前加ResponseBody
 *
 * RestController = Controller + ResponseBody
 */
@RestController
//@Controller
public class TransactionalController {
    @Autowired
    private TransactionInvokeOneService transactionInvokeOneService;

    @Autowired
    private BusinessOneAsyncTask asyncTask;

    @Autowired
    private UserMapper userMapper;

    @RequestMapping("/insert")
    public String insertOne() {
//        transactionInvokeOneService.invokeOne();
        System.out.println(System.currentTimeMillis());
//        asyncTask.doAsyncTask();
        System.out.println(System.currentTimeMillis());

        User user = new User();
        user.setAge(26);
        user.setName("five");
        userMapper.insertOne(user);

        return "success";
    }

}
