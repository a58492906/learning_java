package bean.definition;

import bean.factory.DefaultStudentFactory;
import bean.factory.StudentFactory;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;

/**
 * @author xjm
 * @version 1.0
 * @date 2021-03-16 22:24
 */
@Configuration
public class BeanInitializationDemo
{
    public static void main(String[] args) {
        //创建BeanFactory容器
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext();

        applicationContext.register(BeanInitializationDemo.class);
        //启动
        applicationContext.refresh();
        //非延迟初始化在spring应用上下文启动完成，被初始化
        System.out.println("spring应用上下文已经启动...");
        StudentFactory userFactory=applicationContext.getBean(StudentFactory.class);
         System.out.println("userFactory"+userFactory);
        System.out.println("spring应用上下文准备关闭...");
        //关闭
        applicationContext.close();
        System.out.println("spring应用上下文已经关闭...");
    }

    @Bean(initMethod = "initStudentFactory",destroyMethod = "doDestroy")
    @Lazy(value = false)
    public StudentFactory studentFactory(){
        return new DefaultStudentFactory();

    }
}
