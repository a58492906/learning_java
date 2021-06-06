package bean.factory;

import bean.definition.Student;
import org.springframework.beans.factory.FactoryBean;

/**
 * @author xjm
 * @version 1.0
 * @date 2021-03-16 21:29
 */
public class StudentFactoryBean implements FactoryBean {

    @Override
    public Object getObject() throws Exception {
        return Student.createStudent();
    }

    @Override
    public Class<?> getObjectType() {
        return Student.class;
    }
}
