package controller;

import data.User;

import java.lang.reflect.Array;
import java.util.ArrayList;

public interface UserController {
    void create(String name, String birthday, String info);
    User get();
    ArrayList<User> getAll();
}
