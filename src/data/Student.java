package data;

public class Student extends User {
    private String studentId;

    public Student(String name, String birthday,String studentId) {
        super.setName(name);
        super.setBirthday(birthday);
        this.studentId = studentId;
    }

    public String getStudentId() {
        return studentId;
    }

    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }

    @Override
    public String toString() {
        return "Student{" +
                "Name=" + super.getName() + " " +
                "Birthday=" + super.getBirthday() + " " +
                "studentId='" + studentId + '\'' +
                '}';
    }
}
