package com.atguigu.service;

import com.alibaba.druid.pool.DruidDataSource;
import com.atguigu.bean.Employee;
import com.atguigu.dao.EmployeeMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.Random;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

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
    @Autowired
    private DruidDataSource dataSource;
    @Autowired
    private ThreadPoolExecutor executor;

    public Employee getById(){
        return employeeMapper.getById("1232");
    }

    public void insertOne(Employee employee){
        employeeMapper.insert(employee);
    }

    @Transactional
    public void multiThreadInput(){
        int start = LocalDateTime.now().getSecond();
        // 开启1000个线程
        for (int i = 0; i < 1000; i++) {
            executor.execute(()->{
                Connection connection = null;
                try {
                    connection = dataSource.getConnection();
                    connection.setAutoCommit(false);
                    for (int j = 0; j < 1000; j++) {
                        Employee e = new Employee();
                        final int temp = j;
                        String id = String.valueOf(new Random().nextInt());
                        e.setId(id);
                        e.setUsername("小白"+temp);
                        e.setSex(1);
                        e.setAddress("北京南"+temp);
                        employeeMapper.insert(e);
                    }
                    connection.commit();
                } catch (SQLException e) {
                    // 失败就回滚
                    try {
                        connection.rollback();
                    } catch (SQLException ex) {
                        ex.printStackTrace();
                    }
                    e.printStackTrace();
                }
            });
        }
        int end = LocalDateTime.now().getSecond();
        System.out.println("插入用时："+(end-start)+"秒");
    }
}
