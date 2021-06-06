package bean.definition;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author xjm
 * @version 1.0
 * @date 2021-03-16 21:16
 */
public class SpecialBeanInstantiationDemo {
    public static void main(String[] args) {
        //配置xml配置文件
        //启动spring应用上下文
        BeanFactory beanFactory = new ClassPathXmlApplicationContext("classpath:/META-INF/dependency-instantiation-context.xml\n");
        Student student=  beanFactory.getBean("student-by-static",Student.class);

    }
}
