package com.ip192.spring.config;

import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

@Component
public class RunnerConfig {

    @Bean
    public CommandLineRunner getCommandLine() {
        return (strings) -> {
//            System.out.println(strings.length);
//            System.out.println("Get Command Line");
        };
    }

    @Bean
    public ApplicationRunner runWhileStart() {
        return (args) -> {
//            System.out.println(args.getSourceArgs().length);
//            System.out.println("run while application start");
        };
    }
}
