package bean.definition;

import org.springframework.beans.MutablePropertyValues;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.beans.factory.support.GenericBeanDefinition;

/**
 * @author xjm
 * @version 1.0
 * @date 2021-03-15 22:28
 */
public class BeanDefinitionCreationDemo {
    public static void main(String[] args) {

        //通过BeanDefinitionBuilder构建
        BeanDefinitionBuilder beanDefinitionBuilder=BeanDefinitionBuilder.genericBeanDefinition(Student.class);
        //通过属性设置

        beanDefinitionBuilder.addPropertyValue("id","10").addPropertyValue("name","萌萌哒");
        //获取BeanDefinition
        BeanDefinition beanDefinition=beanDefinitionBuilder.getBeanDefinition();
        //BeanDefinition并非bean终态，可以修改
        System.out.println("beanDefinition"+beanDefinition);
        //2通过AbstractBeanDefinition 以及派生类
        GenericBeanDefinition genericBeanDefinition=new GenericBeanDefinition();
        //设置bean类型
        genericBeanDefinition.setBeanClass(Student.class);
        //通过mutablePropertyValues 批量操作属性
        MutablePropertyValues propertyValues=new MutablePropertyValues();
  /*      propertyValues.addPropertyValue("id","10");
        propertyValues.addPropertyValue("name","萌萌哒");*/
        propertyValues.add("id","10").add("name","萌萌哒");
        genericBeanDefinition.setPropertyValues(propertyValues);



    }
}
