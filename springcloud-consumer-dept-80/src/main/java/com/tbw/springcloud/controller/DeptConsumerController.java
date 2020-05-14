package com.tbw.springcloud.controller;

import com.tbw.springcloud.pojo.Dept;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@RestController
public class DeptConsumerController {

    //消费者不应该有service
    @Autowired
    private RestTemplate restTemplate;

    //在集群中用负载均衡不应该写死  通过服务名来访问
    private static final String REST_URL_PREFIX = "http://localhost:8001";
    //private static final String REST_URL_PREFIX = "http://springcloud-provider-dept";
    @RequestMapping("/consumer/dept/add")
    public boolean add(Dept dept){
        return restTemplate.postForObject(REST_URL_PREFIX+"/dept/add",dept,Boolean.class);
    }

    @RequestMapping("/consumer/dept/get/{id}")
    public Dept get(@PathVariable("id") Long id){
        return restTemplate.getForObject(REST_URL_PREFIX+"/dept/get/"+id,Dept.class);
    }

    @RequestMapping("/consumer/dept/list")
    public List<Dept> list (){
        return restTemplate.getForObject(REST_URL_PREFIX+"/dept/list",List.class);
    }
}
