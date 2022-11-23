package ru.job4j.tracker;

import javax.xml.crypto.Data;
import java.time.LocalDateTime;

public class StartUI {
    public static void main(String[] args) {
        Item date = new Item();
        System.out.println(date.getCreated());
        System.out.println();
        Item info = new Item();
        info.getCreated();
        info.setId(10);
        info.setName("Laptop");
        System.out.println(info);
    }
}
