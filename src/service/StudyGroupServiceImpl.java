package service;

import data.Student;
import data.StudyGroup;
import data.Teacher;
import util.ReaderFromTxt;
import util.WriterToTxt;

import java.util.ArrayList;

public class StudyGroupServiceImpl implements UserService {
    private ArrayList<String> tempList;
    private UserService studentService = new StudentServiceImpl();
    private UserService teacherService = new TeacherServiceImpl();

    @Override
    public void create(Object object, String fileName) {
        if (object instanceof StudyGroup studyGroup) {
            tempList = new ArrayList<>();
            tempList.add(studyGroup.getClass().getSimpleName() + "{");
            WriterToTxt.write(tempList,fileName);
            teacherService.create(studyGroup.getGroupTeacher(),fileName);
            ArrayList<Student> listSt = new ArrayList<>(studyGroup.getStudentsList());
            for (int i = 0; i < studyGroup.getStudentsList().size(); i++) {
                studentService.create(listSt.get(i),fileName);
            }
            tempList = new ArrayList<>();
            tempList.add("}");
            WriterToTxt.write(tempList,fileName);

        } else System.out.println("Ошибка!");
    }

    @Override
    public StudyGroup read(String fileName) {
        tempList = ReaderFromTxt.read(fileName);
        if (tempList == null) {
            System.out.println("Ощибка чтения!");
        } else {
            StudyGroup studyGroup = new StudyGroup();
            for (int i = 0; i < tempList.size(); i++) {
                if (tempList.get(i).equals(Teacher.class.getSimpleName())) {
                    Teacher teacher = new Teacher(tempList.get(++i), tempList.get(++i), tempList.get(++i));
                    studyGroup.changeTeacher(teacher);
                }else if (tempList.get(i).equals(Student.class.getSimpleName())){
                    studyGroup.addStudent(new Student(tempList.get(++i), tempList.get(++i), tempList.get(++i)));
                }
            }
            return studyGroup;
        }
        return null;
    }
}
