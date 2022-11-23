package ru.job4j.tracker;

import java.util.Arrays;

public class DroppArray {
    public static void main(String[] args) {
        String[] names = {"Kirill", null, "Maria", "Ilya"};
        System.arraycopy(names, 2, names, 1, 2);
        System.out.println(Arrays.toString(names));

        String[] namess = {"Petr", null, "Ivan", "Stepan", "Fedor"};
        System.arraycopy(namess, 2, namess, 1, 3);
        System.out.println(Arrays.toString(namess));
    }
}
