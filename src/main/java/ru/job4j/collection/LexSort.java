package ru.job4j.collection;

import java.util.Comparator;

public class LexSort implements Comparator<String> {
    @Override
    public int compare(String left, String right) {
        String[] numOne = left.split("\\. ");
        String[] numTwo = right.split("\\. ");
        int first = 0;
        int second = 0;
        int max = Math.max(left.length(), right.length());
        for (int index = 0; index < max; index++) {
            first = Integer.parseInt(numOne[0]);
            second = Integer.parseInt(numTwo[0]);
        }
        return Integer.compare(first, second);
    }
}
