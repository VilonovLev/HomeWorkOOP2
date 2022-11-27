package com.company;

import controller.*;
import data.*;
import service.*;


import java.math.BigDecimal;
import java.util.List;
import java.util.logging.Logger;

public class Main {


    public static void main(String[] args) {
        StudentControllerImpl studentController = new StudentControllerImpl();
        studentController.create("Иван", "20.06.1984","012");
        studentController.create("Иван", "20.06.1984","014");
        studentController.create("Иван", "20.06.1984","013");
        studentController.create("Иван", "20.06.1984","015");
        TeacherControllerImpl teacherController = new TeacherControllerImpl();
        teacherController.create("Иван", "20.06.1984","Математика");
        StudyGroupControllerImpl studyGroupController = new StudyGroupControllerImpl();
        studyGroupController.create(teacherController.get(),studentController.getAll());

    }
}
