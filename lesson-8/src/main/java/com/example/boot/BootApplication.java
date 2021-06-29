package com.example.boot;

import com.example.boot.JDBC.XAOrderService;
import com.example.boot.JDBC.configuation.TransactionConfiguration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Import;

import javax.annotation.PostConstruct;

@SpringBootApplication
@Import(TransactionConfiguration.class)
@EnableConfigurationProperties
public class BootApplication {
    @Autowired
    private XAOrderService orderService;

    public static void main(String[] args) {
        SpringApplication.run(BootApplication.class, args);


    }

    @PostConstruct
    public void executeOrderService() {
        orderService.init();
        orderService.selectAll();
        orderService.cleanup();
    }

}
