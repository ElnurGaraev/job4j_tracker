package ru.job4j.ex;

public class Find {
    public static String get(String[] data, int index) {
        if (index < 0 || index >= data.length) {
            throw new IllegalArgumentException("Index out of bound.");
        }
        return data[index];
    }

    public static void main(String[] args) {
        String[] data = {"One", "two", "three"};
        int index = 5;
        String rsl = get(data, index);
        System.out.println(rsl);
    }
}
