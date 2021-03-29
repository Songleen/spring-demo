import com.atguigu.config.AppConfig;
import com.atguigu.service.EmployeeService;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

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
        service.multiThreadInput();

        Thread.sleep(2000);
        System.out.println("主线程结束执行……");
    }
}
