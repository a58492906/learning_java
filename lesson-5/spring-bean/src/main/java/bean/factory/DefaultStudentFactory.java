package bean.factory;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

/**
 * @author xjm
 * @version 1.0
 * @date 2021-03-16 21:25
 */
public class DefaultStudentFactory implements StudentFactory, InitializingBean, DisposableBean {

      @PostConstruct
    public void init(){
          System.out.println("@ PostConstruct studentInstance 初始化中 ");
      }

      public void  initStudentFactory(){
          System.out.println("initStudentFactory studentInstance 初始化中 ");
      }

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("InitializingBean#afterPropertiesSet  userFactory 初始化中 ");
    }

  @PreDestroy
  public void destroyBean(){
      System.out.println("@ PreDestroy userFactory 销毁中。。。 ");
  }


    @Override
    public void destroy() throws Exception {
        System.out.println("DisposableBean#destroy方法 StudentFactory 销毁中。。。 ");
    }

    public void doDestroy()  {
        System.out.println("自定义destroy方法 StudentFactory 销毁中。。。 ");
    }
    //示例被回收

    @Override
    public void finalize() throws Throwable{
        System.out.println("当前对象 DefaultStudentFactory正在被回收。 ");
    };

}
