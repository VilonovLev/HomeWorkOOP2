package controller;

import data.Student;
import data.User;

import java.util.ArrayList;
import java.util.Stack;

public class StudentControllerImpl implements UserController {
    private static Stack<Student> studentStack = new Stack<>();

    @Override
    public void create(String name, String birthday, String info) {
        Student currentStudent = new Student(name,birthday,info);
        studentStack.add(currentStudent);
    }
    @Override
    public User get() {
        if (!studentStack.isEmpty()) {
            return studentStack.pop();
        }
        return null;
    }

    @Override
    public ArrayList<User> getAll() {
        return new ArrayList<>(studentStack);
    }
}
