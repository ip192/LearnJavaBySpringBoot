package com.ip192.spring;

import org.activiti.engine.ProcessEngine;
import org.activiti.engine.ProcessEngineConfiguration;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * @SpringBootApplication中的@EnableAutoConfiguration可以将所有@Configuration加载到容器里
 * @Import注解可用于将多个配置信息类导入一个汇总配置类里 在getApplicationContext时通过一个入口就可以访问到其他导入的各个配置
 */
@EnableAsync
@EnableScheduling
@EnableTransactionManagement
@SpringBootApplication
@ServletComponentScan(basePackages = "com.ip192.spring")
public class Entrance {
    /**
     * 可以在此入口开启异步 @EnableAsync
     * 借助一个@Configuration配置类用于指定@Async任务的线程池 ThreadPoolTaskExecutor
     * 使用@Async时指定线程池名称
     */

    public static void main(String[] args) {
        SpringApplication.run(Entrance.class, args);

        new Entrance().createActivityEngine();
    }


    private void createActivityEngine() {
        /*        *1.通过代码形式创建
         *  - 取得ProcessEngineConfiguration对象
         *  - 设置数据库连接属性
         *  - 设置创建表的策略 （当没有表时，自动创建表）
         *  - 通过ProcessEngineConfiguration对象创建 ProcessEngine 对象*/

        //取得ProcessEngineConfiguration对象
        ProcessEngineConfiguration engineConfiguration=ProcessEngineConfiguration.
                createStandaloneProcessEngineConfiguration();
        //设置数据库连接属性
        engineConfiguration.setJdbcDriver("com.mysql.jdbc.Driver");
        engineConfiguration.setJdbcUrl("jdbc:mysql://127.0.0.1:3306/demo?createDatabaseIfNotExist=true&useUnicode=true&characterEncoding=utf8");
        engineConfiguration.setJdbcUsername("ip192");
        engineConfiguration.setJdbcPassword("abcd1234");


        // 设置创建表的策略 （当没有表时，自动创建表）
        //		  public static final java.lang.String DB_SCHEMA_UPDATE_FALSE = "false";//不会自动创建表，没有表，则抛异常
        //		  public static final java.lang.String DB_SCHEMA_UPDATE_CREATE_DROP = "create-drop";//先删除，再创建表
        //		  public static final java.lang.String DB_SCHEMA_UPDATE_TRUE = "true";//假如没有表，则自动创建
        engineConfiguration.setDatabaseSchemaUpdate("true");
        //通过ProcessEngineConfiguration对象创建 ProcessEngine 对象
        ProcessEngine processEngine = engineConfiguration.buildProcessEngine();
        System.out.println("流程引擎创建成功!");
    }
}
