package service;

import data.Teacher;
import data.User;
import util.ReaderFromTxt;
import util.WriterToTxt;

import java.util.ArrayList;

public class TeacherServiceImpl implements UserService {
    private ArrayList<String> tempList;

    @Override
    public void create(Object object, String fileName) {
        if (object instanceof Teacher user) {
            tempList = new ArrayList<>();
            tempList.add(user.getClass().getSimpleName());
            tempList.add(user.getName());
            tempList.add(user.getBirthday());
            tempList.add(user.getDisciplesTaught());
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
                if (tempList.get(i).equals(Teacher.class.getSimpleName())) {
                    return new Teacher(tempList.get(++i), tempList.get(++i), tempList.get(++i));
                }
            }
        }

        return null;
    }
}
