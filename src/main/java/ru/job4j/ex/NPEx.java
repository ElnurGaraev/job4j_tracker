package ru.job4j.ex;

public class NPEx {
    public static void main(String[] args) {
        String[] shop = new String[5];
        shop[0] = "Petr Arsentev";
        for (int index = 0; index < shop.length; index++) {
            String el = shop[index];
            if (el != null) {
                System.out.println(el + " has a size : " + el.length());
            }
        }
    }
}
