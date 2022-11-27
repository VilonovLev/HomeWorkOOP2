package controller;

import data.StudyGroup;
import data.User;

import java.util.List;

public interface StudyGroupController {
    void create(User teacher, List<User> studentList);
    StudyGroup get();
}
