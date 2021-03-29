package com.atguigu.bean;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ApplicationContext;

/**
 * @Describe
 * @ClassName
 * @Author 李松林
 * @Date 2020/8/19 16:08
 */
public class Bird implements Animal {
    @Value("翠鸟")
    private String name;
    @Value("蓝色")
    private String color;

    private Cat cat;

    public Cat getCat() {
        return cat;
    }

    public void setCat(Cat cat) {
        this.cat = cat;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    @Override
    public void eat() {
        System.out.println("鸟吃虫！");
    }

    @Override
    public String toString() {
        return "Bird{" +
                "name='" + name + '\'' +
                ", color='" + color + '\'' +
                '}';
    }
}
