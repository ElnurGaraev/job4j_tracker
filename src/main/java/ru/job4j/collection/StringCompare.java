package ru.job4j.collection;

import java.util.Comparator;

public class StringCompare implements Comparator<String> {
    @Override
    public int compare(String left, String right) {
        int minSize = Math.min(left.length(), right.length());
        for (int index = 0; index < minSize; index++) {
           int compare = Character.compare(left.charAt(index), right.charAt(index));
            if (compare != 0) {
                return compare;
            }
        }
        return Integer.compare(left.length(), right.length());
    }
}
