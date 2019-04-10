package com.ewing.service_provider.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@EnableEurekaClient
@RestController
public class UserService {

    @Value("${server.port}")
    String port;

    @RequestMapping("/")
    public String home(){
        return "Hello world,port:"+port+"!";
    }
}
