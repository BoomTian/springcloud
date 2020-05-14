package com.tbw.springcloud.service;

import com.tbw.springcloud.pojo.Dept;
import feign.hystrix.FallbackFactory;
import org.springframework.stereotype.Component;

import java.util.List;

//降级
@Component
public class DeptClientServiceFallBack implements FallbackFactory {
    @Override
    public DeptClientService create(Throwable throwable) {
        return new DeptClientService() {
            @Override
            public boolean add(Dept dept) {
                return false;
            }

            @Override
            public Dept get(Long id) {
                return new Dept().
                        setDeptno(id).
                        setDb_source("no database in mysql ").
                        setDname("服务降级被关闭");
            }

            @Override
            public List<Dept> list() {
                return null;
            }
        };
    }
}
