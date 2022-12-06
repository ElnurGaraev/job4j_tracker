package ru.job4j.collection;

import java.util.HashSet;

public class UniqueText {
    public boolean isEquals(String originText, String duplicateText) {
        boolean rsl = true;
        String[] origin = originText.split(" ");
        String[] text = duplicateText.split(" ");
        HashSet<String> check = new HashSet<>();
        for (String originTex : origin) {
            check.add(originTex);
        }
        for (String textDup : text) {
            if (!check.contains(textDup)) {
                rsl = false;
                break;
            }
        }
        return rsl;
    }
}
