package com.atguigu.bean;

/**
 * @Describe
 * @ClassName
 * @Author 李松林
 * @Date 2021/3/26 15:31
 */
public class Employee {
    private String id;
    private String username;
    private int sex;
    private String address;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public int getSex() {
        return sex;
    }

    public void setSex(int sex) {
        this.sex = sex;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id='" + id + '\'' +
                ", username='" + username + '\'' +
                ", sex=" + sex +
                ", address='" + address + '\'' +
                '}';
    }
}
