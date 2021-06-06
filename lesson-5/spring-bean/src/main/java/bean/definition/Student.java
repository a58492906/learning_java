package bean.definition;

/**
 * @author xjm
 * @version 1.0
 * @date 2021-06-06 14:59
 */


public class Student {
    private  Long id;
    private String name;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }



    public static Student createStudent(){
        return new Student();
    }
}
