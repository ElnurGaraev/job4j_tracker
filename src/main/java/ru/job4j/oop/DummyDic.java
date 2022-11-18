package ru.job4j.oop;

public class DummyDic {
    public String engToRus(String end) {
        String rsl = "Неизвестное слово: " + end;
        return rsl;
    }

    public static void main(String[] args) {
        DummyDic name = new DummyDic();
        String word = "transformer";
        System.out.println(name.engToRus(word));
    }
}
