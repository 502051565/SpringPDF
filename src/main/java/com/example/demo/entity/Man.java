package com.example.demo.entity;

import java.io.Serializable;

/**
 * @author monkey_lwy@163.com
 * @date 2019-03-05 14:18
 * @desc
 */
public class Man implements Serializable {

    private static final long serialVersionUID = 1L;

    private Integer id;
    private String age;
    private String name;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }
}
