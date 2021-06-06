package bean.definition;

/**
 * @author xjm
 * @version 1.0
 * @date 2021-06-06 15:30
 */
public class Class{
         private  Long Id;

        private  Long studentId;

        private String name;

        private String teacher;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

    public Long getStudentId() {
        return studentId;
    }

    public void setStudentId(Long studenId) {
        this.studentId = studenId;
    }

    public String getTeacher() {
        return teacher;
    }

    public void setTeacher(String teacher) {
        this.teacher = teacher;
    }

    public Long getId() {
        return Id;
    }

    public void setId(Long id) {
        Id = id;
    }

    public static Class createClass(){
            return new Class();
        }
}