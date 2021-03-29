import com.atguigu.bean.Employee;
import com.atguigu.config.AppConfig;
import com.atguigu.service.EmployeeService;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * @Describe
 * @ClassName
 * @Author 李松林
 * @Date 2021/3/26 11:30
 */
@Slf4j
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {AppConfig.class})
public class BeanTest {

    @Autowired
    private EmployeeService employeeService;

    @Test
    public void test1() {
        Employee e = employeeService.getById();
        System.out.println(e);
    }
}
