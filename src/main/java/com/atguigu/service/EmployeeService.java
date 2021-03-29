package com.atguigu.service;

import com.atguigu.bean.Employee;
import com.atguigu.dao.EmployeeMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Describe
 * @ClassName
 * @Author 李松林
 * @Date 2021/3/26 16:43
 */
@Service
public class EmployeeService {

    @Autowired
    private EmployeeMapper employeeMapper;

    public Employee getById(){
        return employeeMapper.getById("1232");
    }

    public void insertOne(Employee employee){
        employeeMapper.insert(employee);
    }
}
