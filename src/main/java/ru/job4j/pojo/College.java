package ru.job4j.pojo;

import java.util.Date;

public class College {
    public static void main(String[] args) {
        Student student = new Student();
        student.setFullName("Ivanov Ivan Ivanich");
        student.setGroup(12);
        student.setCreate(new Date());
        System.out.println("Student: " + student.getFullName() + " group: " + student.getGroup()
        + System.lineSeparator() + student.getCreate());
    }
}
