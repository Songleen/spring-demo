package com.atguigu.component;

import com.atguigu.bean.Animal;
import com.atguigu.bean.Cat;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

/**
 * @Describe
 * @ClassName
 * @Author 李松林
 * @Date 2021/3/26 11:42
 */
//@Component
public class Tiger {

//    @Bean
//    public Animal myCat(){
//        return new Cat();
//    }

    @Value("小白")
    private String name;
    @Value("东北虎")
    private String brand;

    @Override
    public String toString() {
        return "Tiger{" +
                "name='" + name + '\'' +
                ", brand='" + brand + '\'' +
                '}';
    }
}
