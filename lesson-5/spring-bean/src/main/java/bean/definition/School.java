package bean.definition;

/**
 * @author xjm
 * @version 1.0
 * @date 2021-06-06 15:33
 */
public class School {
    private  Long id;
    private String name;

    private  Long teacherId;

    private  Long studentId;
    private  Long classId;

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

    public Long getTeacherId() {
        return teacherId;
    }

    public void setTeacherId(Long teacherId) {
        this.teacherId = teacherId;
    }

    public Long getStudentId() {
        return studentId;
    }

    public void setStudentId(Long studentId) {
        this.studentId = studentId;
    }

    public Long getClassId() {
        return classId;
    }

    public void setClassId(Long classId) {
        this.classId = classId;
    }

    public static Student createStudent(){
        return new Student();
    }
}

