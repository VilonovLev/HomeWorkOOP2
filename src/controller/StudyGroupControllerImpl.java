package controller;

import data.Student;
import data.StudyGroup;
import data.Teacher;
import data.User;

import java.util.List;
import java.util.Stack;

public class StudyGroupControllerImpl implements StudyGroupController{
    private static Stack<StudyGroup> studyGroupsStack;

    static {
        studyGroupsStack = new Stack<>();
    }


    @Override
    public void create(User teacher, List<User> studentList) {
        StudyGroup currentStudyGroup = new StudyGroup();
        TeacherControllerImpl teacherController = new TeacherControllerImpl();
        currentStudyGroup.changeTeacher((Teacher) teacherController.get());
        for (var student : studentList) {
            currentStudyGroup.addStudent((Student) student);
        }
    }

    @Override
    public StudyGroup get() {
        if (studyGroupsStack.size() > 0) {
            return studyGroupsStack.pop();
        }
        return null;
    }

}
