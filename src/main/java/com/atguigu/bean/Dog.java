package com.atguigu.bean;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * @Describe
 * @ClassName
 * @Author 李松林
 * @Date 2020/8/18 12:32
 */
public class Dog {
    @Value("小黄")
    private String name;
    @Value("11")
    private int age;


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void update(String sql){
        System.out.println(sql);
    }

    @Override
    public String toString() {
        return "Dog{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
