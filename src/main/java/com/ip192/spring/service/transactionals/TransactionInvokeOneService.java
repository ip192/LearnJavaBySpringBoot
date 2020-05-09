package com.ip192.spring.service.transactionals;

import com.ip192.spring.entity.User;
import com.ip192.spring.mapper.UserMapper;
import org.springframework.beans.factory.BeanNameAware;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
public class TransactionInvokeOneService implements BeanNameAware {
    @Autowired
    private UserMapper userMapper;
    @Autowired
    private TransactionInvokeTwoService transactionInvokeTwoService;

    /**
     * 子事务使用Propagation.REQUIRES_NEW传播级别，并在父事务中try/catch
     * 二者发生异常，各自回滚互不影响
     */
    @Transactional(propagation = Propagation.REQUIRED)
    public void invokeOne() {
        User user = new User();
        user.setAge(10);
        user.setName("one");
        userMapper.insertOne(user);

        try {
            transactionInvokeTwoService.invokeTwo();
        } catch (Exception e) {
            System.out.println("sub transaction exception");
        }
//        int i = 1 / 0;
    }

    @Override
    public void setBeanName(String s) {

    }
}
