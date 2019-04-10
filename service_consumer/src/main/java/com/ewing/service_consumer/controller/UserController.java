package com.ewing.service_consumer.controller;

import com.ewing.service_consumer.client.UserClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {
    @Autowired
    private UserClient userClient;

    @GetMapping(value = "/hello")
    public String hello(){
        return userClient.consumer();
    }
}
