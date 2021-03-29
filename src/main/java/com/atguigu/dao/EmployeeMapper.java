package com.atguigu.dao;

import com.atguigu.bean.Employee;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

/**
 * @Describe
 * @ClassName
 * @Author 李松林
 * @Date 2021/3/26 15:33
 */

public interface EmployeeMapper {

//    @Select("select * from Employee where id = #{id}")
    Employee getById(@Param("id") String id);

//    @Insert("insert into Employee('username',) ")
    void insert(Employee employee);
}
