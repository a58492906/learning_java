package bean.factory;


import bean.definition.Student;

/**
 * @author xjm
 * @version 1.0
 * @date 2021-03-16 21:20
 */
public interface StudentFactory
{

    default Student createStudent (){
        return Student.createStudent();
    }

    void initStudentFactory();

    void doDestroy();
}
