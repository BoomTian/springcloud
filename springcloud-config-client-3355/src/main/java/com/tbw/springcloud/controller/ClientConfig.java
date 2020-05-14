package com.tbw.springcloud.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
public class ClientConfig {

    //git中有配置可以直接注入
    @Value("${spring.application.name}")
    private String applicationName;
}
