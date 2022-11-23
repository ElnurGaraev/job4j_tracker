package ru.job4j.pojo;

import java.util.Date;

public class LicenseContains {
    public static void main(String[] args) {
        License first = new License();
        first.setOwner("Ivanov");
        first.setModel("Toyota");
        first.setCode("x123");
        first.setCreate(new Date());
        License second = new License();
        second.setOwner("Ivanov");
        second.setModel("Toyota");
        second.setCode("x123");
        second.setCreate(new Date());
        boolean eq = first.equals(second);
        System.out.println(eq);
    }
}
