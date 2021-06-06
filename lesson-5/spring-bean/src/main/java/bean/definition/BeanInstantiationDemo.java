package bean.definition;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author xjm
 * @version 1.0
 * @date 2021-03-16 21:16
 */
public class BeanInstantiationDemo {
    public static void main(String[] args) {
        //配置xml配置文件
        //启动spring应用上下文
        BeanFactory beanFactory = new ClassPathXmlApplicationContext("classpath:/META-INF/dependency-definitions-context.xml\n");
        Student student=  beanFactory.getBean("student-by-static",Student.class);
         System.out.println("student"+student);
        Student studentInstance=  beanFactory.getBean("student-by-instance-method",Student.class);
        System.out.println("student_instance"+studentInstance);
        System.out.println(student==studentInstance);
        Student studentByFactoryBean=  beanFactory.getBean("student-by-factory-bean",Student.class);
        System.out.println("studentByFactoryBean"+studentByFactoryBean);
    }
}
