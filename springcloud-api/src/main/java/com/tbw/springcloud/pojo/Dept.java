package com.tbw.springcloud.pojo;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 * 部门表(Dept)实体类
 *
 * @author makejava
 * @since 2020-04-10 12:54:32
 */
@Data
@NoArgsConstructor
@Accessors(chain = true)  //开启链式写法
public class Dept implements Serializable {
    private static final long serialVersionUID = -25888791791009711L;
    
    private Long deptno;
    
    private String dname;
    
    private String db_source;

    public Dept(String dname){
        this.dname = dname;
    }


}