package com.hebaohua.part6_Spring.config;

import java.awt.*;

/**
 * @author Hebh
 * @date 2018/2/1
 * @description:
 */
public class User {
    private String name;
    private Integer age;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public User(String name, Integer age) {
        this.name = name;
        this.age = age;
    }

    public void init_user(){
        System.out.println("initUser");
    }

    public void destroy_user(){
        System.out.println("destoryUser");
    }

    public User() {
        super();
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
