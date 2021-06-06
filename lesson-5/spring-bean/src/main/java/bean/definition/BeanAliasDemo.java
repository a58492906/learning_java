package bean.definition;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author xjm
 * @version 1.0
 * @date 2021-03-15 23:16
 */
public class BeanAliasDemo {
    public static void main(String[] args) {
        //配置xml配置文件
        //启动spring应用上下文
        BeanFactory beanFactory = new ClassPathXmlApplicationContext("classpath:/META-INF/dependency-bean-context.xml");
        //通过别名获取bean
       Student student= beanFactory.getBean("student",Student.class);
        Student student2= beanFactory.getBean("student2",Student.class);

    }
    }
