package bean.definition;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.ListableBeanFactory;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Map;

/**
 * @author xjm
 * @version 1.0
 * @date 2021-03-14 22:37
 */
public class IocContaionerDemo {

    public static void main(String[] args){
        //创建BeanFactory容器
        DefaultListableBeanFactory defaultListableBeanFactory=new DefaultListableBeanFactory();
        XmlBeanDefinitionReader reader=new XmlBeanDefinitionReader(defaultListableBeanFactory);
        //Xml路径
        String location =  "classpath:/META-INF/dependency-lockupnew-context.xml";
        //加载资源
        int res=   reader.loadBeanDefinitions(location);
        //依赖注入(内建的依赖)
        System.out.println("res"+res);
        //依赖查找
        //按照类型查找集合对象
        lookUpCollectionType(defaultListableBeanFactory);
    }

    private static void  lookUpCollectionType(BeanFactory beanFactory){
        if(beanFactory instanceof ListableBeanFactory){
            ListableBeanFactory listableBeanFactory=(ListableBeanFactory)beanFactory;
            Map<String, Student> map=  listableBeanFactory.getBeansOfType(Student.class);
            System.out.println("查找集合"+map);
        }


    }
}
