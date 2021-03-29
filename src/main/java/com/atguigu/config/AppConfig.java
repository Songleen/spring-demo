package com.atguigu.config;

import com.alibaba.druid.pool.DruidDataSource;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;

import javax.sql.DataSource;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @Describe
 * @ClassName
 * @Author 李松林
 * @Date 2020/8/18 12:31
 */
@Configuration
@PropertySource("classpath:jdbc.properties")
@ComponentScan("com.atguigu")
@MapperScan(value = "com.atguigu.dao")
public class AppConfig {
    @Value("${jdbc.driverClassName}")
    private String driverClassName;
    @Value("${jdbc.url}")
    private String jdbcUrl;
    @Value("${jdbc.username}")
    private String username;
    @Value("${jdbc.password}")
    private String password;

    @Value("${threadpool.corenum}")
    private int corenum;
    @Value("${threadpool.maxnum}")
    private int maxnum;
    @Value("${threadpool.keeplive}")
    private long keeplive;


    @Bean
    public DataSource dataSource() {
        //这里使用 druid 数据源
        DruidDataSource dataSource = new DruidDataSource();
        dataSource.setDriverClassName(driverClassName);
        dataSource.setUrl(jdbcUrl);
        dataSource.setUsername(username);
        dataSource.setPassword(password);
        return dataSource;
    }

    @Bean
    public SqlSessionFactory sqlSessionFactory() throws Exception {
        SqlSessionFactoryBean factoryBean = new SqlSessionFactoryBean();
        factoryBean.setDataSource(dataSource());
        factoryBean.setMapperLocations(new PathMatchingResourcePatternResolver()
                .getResources("classpath" +
                        ":mapper/*.xml"));
        SqlSessionFactory object = factoryBean.getObject();
        System.out.println(object);
        return object;
    }

    // 线程池
    @Bean
    public ThreadPoolExecutor threadPoolExecutor() {
        ThreadPoolExecutor executor = new ThreadPoolExecutor(corenum, maxnum, keeplive, TimeUnit.SECONDS,
                new LinkedBlockingDeque<>(2000));
        return executor;
    }
}
