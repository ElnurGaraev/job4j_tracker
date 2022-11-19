package ru.job4j.oop;

public class DummyDic {
    public String engToRus(String end) {
        return "Неизвестное слово. " + end;
    }

    public static void main(String[] args) {
        DummyDic name = new DummyDic();
        String word = "Unknown word";
        System.out.println(name.engToRus(word));
    }
}
