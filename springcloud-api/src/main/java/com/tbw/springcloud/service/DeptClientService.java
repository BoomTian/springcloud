package com.tbw.springcloud.service;

import com.tbw.springcloud.pojo.Dept;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@Component
@FeignClient(value = "springcloud-provider-dept",fallbackFactory = DeptClientServiceFallBack.class)
public interface DeptClientService {

    @PostMapping("/dept/add")
    public boolean add(Dept dept);

    @GetMapping("/dept/get/{id}")
    public Dept get(@PathVariable("id") Long id);

    @GetMapping("dept/list")
    public List<Dept> list ();
}
