package com.hebaohua.part5_DB.day3;

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
        super();
        this.name = name;
        this.age = age;
    }

    public User() {
        super();
    }
}
