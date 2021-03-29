package com.atguigu.extend;

/**
 * @Describe
 * @ClassName
 * @Author 李松林
 * @Date 2021/3/28 20:05
 */
public class Father {
    private String name;
    private Integer age;

    public Father() {
        say();
    }

    public void say(){
        System.out.println("我是你老爸！");
    }

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
}
