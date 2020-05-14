package com.tbw.springcloud.controller;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.tbw.springcloud.pojo.Dept;
import com.tbw.springcloud.service.DeptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

//提供restful服务
@RestController
public class DeptContorller {

    @Autowired
    DeptService deptService;

    @PostMapping("/dept/add")
    public boolean addDept(Dept dept){
        return deptService.addDept(dept);
    }
    @GetMapping("/dept/get/{id}")
    @HystrixCommand(fallbackMethod = "hystrixGet")
    public Dept queryById(@PathVariable("id") Long id){
        Dept dept = deptService.queryById(id);
        if (dept == null) {
            throw  new RuntimeException("不存在该用户");
        }
        return dept;
    }
    public Dept hystrixGet(@PathVariable("id") Long id){
            return  new Dept().setDeptno(id).setDb_source("no database in mysql ").setDname("不存在");
    }
    @GetMapping("/dept/list")
    public List<Dept> queryAll (){
        return deptService.queryAll();
    }

}
