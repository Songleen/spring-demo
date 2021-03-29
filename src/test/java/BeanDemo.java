import com.atguigu.bean.Employee;
import com.atguigu.config.AppConfig;
import com.atguigu.service.EmployeeService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.sql.SQLOutput;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Random;

/**
 * @Describe
 * @ClassName
 * @Author 李松林
 * @Date 2021/3/26 17:23
 */
public class BeanDemo {
    public static void main(String[] args) throws InterruptedException {
        AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(AppConfig.class);
        EmployeeService service = (EmployeeService) ac.getBean("employeeService");
        LocalDateTime start = LocalDateTime.now();
        for (int i = 0; i < 500; i++) {
            new Thread(()->{
                Employee e = new Employee();
                String s = String.valueOf(new Random().nextInt());
                e.setId(s);
                e.setUsername("小强");
                e.setSex(2);
                e.setAddress("北京");
                service.insertOne(e);
            },String.valueOf(i)).start();
        }

        Thread.sleep(400);
    }
}
