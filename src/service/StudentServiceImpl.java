package service;

import data.Student;
import data.User;
import util.*;

import java.util.ArrayList;


public class StudentServiceImpl implements UserService {
    private ArrayList<String> tempList;

    @Override
    public void create(Object object, String fileName) {
        if (object instanceof Student user) {
            tempList = new ArrayList<>();
            tempList.add(user.getClass().getSimpleName());
            tempList.add(user.getName());
            tempList.add(user.getBirthday());
            tempList.add(user.getStudentId());
            WriterToTxt.write(tempList, fileName);
        } else System.out.println("Ошибка!");
    }

    @Override
    public User read(String fileName) {
        tempList = ReaderFromTxt.read(fileName);
        if (tempList == null) {
            System.out.println("Ощибка чтения!");
        } else {
            for (int i = 0; i < tempList.size(); i++) {
                if (tempList.get(i).equals(Student.class.getSimpleName())) {
                    return new Student(tempList.get(++i), tempList.get(++i), tempList.get(++i));
                }
            }
        }

        return null;
    }
}
