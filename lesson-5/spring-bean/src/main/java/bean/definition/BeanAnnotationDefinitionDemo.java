package bean.definition;

import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.beans.factory.support.BeanDefinitionReaderUtils;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Import;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import sun.misc.ObjectInputFilter;

import java.util.Map;

/**
 * @author xjm
 * @version 1.0
 * @date 2021-03-15 23:20
 */
@Import(BeanAnnotationDefinitionDemo.config.class)//通过@import引入

public class BeanAnnotationDefinitionDemo {
    public static void main(String[] args) {

        //创建BeanFactory容器
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext();
        //注册configuration class配置类
        applicationContext.register(BeanAnnotationDefinitionDemo.class);
        //通过BeanDefinition注册api实现
        registerBeanDefinition(applicationContext,"api-student");
        //非命名方式
        registerBeanDefinition(applicationContext);
        applicationContext.refresh();
        //通过@Bean定义
        //通过@Component
        //依赖查找
        Map<String,config> map=applicationContext.getBeansOfType(config.class);
        Map<String,Student> usermap=applicationContext.getBeansOfType(Student.class);
        System.out.println("config 类型的所有beans"+map);
        System.out.println("Student 类型的所有beans"+usermap);
        //关闭应用上下文
        applicationContext.close();

    }
    public static void registerBeanDefinition( BeanDefinitionRegistry registry,String beanName) {
        BeanDefinitionBuilder beanDefinitionBuilder =BeanDefinitionBuilder.genericBeanDefinition(Student.class);
        beanDefinitionBuilder.addPropertyValue("id","10").addPropertyValue("name","萌萌哒");
        //注册 registerBeanDefinition
        if (StringUtils.hasText(beanName)){
            registry.registerBeanDefinition(beanName,beanDefinitionBuilder.getBeanDefinition());

        }
        else {
            //非命名的方式
            BeanDefinitionReaderUtils.registerWithGeneratedName(beanDefinitionBuilder.getBeanDefinition(),registry);
        }

    }
    public static void registerBeanDefinition( BeanDefinitionRegistry registry) {

        //注册 BeanDenfition
        registerBeanDefinition(registry,null);

    }
    @Component//定义当前类作为springBean组件
    public static class config {
        //通过注解定义bean

        @Bean(name = {"student", "student2"})
        public Student student() {
            Student student = new Student();
            student.setId(10L);
            student.setName("注解用户");
            return student;


        }
    }


}
