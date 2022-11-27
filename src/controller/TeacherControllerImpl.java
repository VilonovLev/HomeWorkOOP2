package controller;

import data.Teacher;
import data.User;

import java.util.ArrayList;
import java.util.Stack;

public class TeacherControllerImpl implements UserController{
    private static Stack<Teacher> teacherStack ;

    static {
        teacherStack = new Stack<>();
    }

    @Override
    public void create(String name, String birthday, String info) {
        Teacher currentTeacher = new Teacher(name,birthday,info);
        teacherStack.push(currentTeacher);
    }

    @Override
    public User get() {
        if (!teacherStack.isEmpty()) {
            return teacherStack.pop();
        }
        return null;
    }

    @Override
    public ArrayList<User> getAll() {
        return new ArrayList<>(teacherStack);
    }
}
