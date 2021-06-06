package bean.definition;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @author xjm
 * @version 1.0
 * @date 2021-03-17 22:54
 */
public class BeanGarbageCollectionDemo {
    public static void main(String[] args) {

        //创建BeanFactory容器
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext();

        applicationContext.register(BeanInitializationDemo.class);
        //启动
        applicationContext.refresh();
        //关闭
        applicationContext.close();
        System.out.println("spring 应用上下文已关闭");
        //提示 jvm可以做回收操作
        System.gc();
    }
}
