package data;

import java.util.ArrayList;
import java.util.List;

public class StudyGroup {
    private Teacher groupTeacher;
    private List<Student> studentsList;

    public StudyGroup(Teacher groupTeacher, List<Student> studentsList) {
        this.groupTeacher = groupTeacher;
        this.studentsList = studentsList;
    }

    public StudyGroup(Teacher groupTeacher) {
        this(groupTeacher,new ArrayList<>());
    }

    public StudyGroup() {
        this(new Teacher("","",""));
    }


    public void changeTeacher(Teacher teacher){
        this.groupTeacher = teacher;
    }

    public void addStudent(Student student) {
        if (!studentsList.contains(student)) {
            studentsList.add(student);
        }
    }

    public void removeStudent(Student student) {
        if (studentsList.contains(student)) {
            studentsList.remove(student);
        }
    }

    public Teacher getGroupTeacher() {
        return groupTeacher;
    }

    public List<Student> getStudentsList() {
        return studentsList;
    }

    @Override
    public String toString() {
        return "StudyGroup{" + groupTeacher +
                ", Students=" + studentsList +
                '}';
    }
}
