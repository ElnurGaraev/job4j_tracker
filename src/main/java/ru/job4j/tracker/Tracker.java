package ru.job4j.tracker;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Tracker {
    private List<Item> items = new ArrayList<>();
    //private final Item[] items = new Item[100];УДАЛИТЬ
    private int ids = 1;
    //private int size = 0; УДАЛИТЬ

    public Item add(Item item) {
        item.setId(ids++);
        items.add(item);
        //items[size++] = item;УДАЛИТЬ
        return item;
    }

    public List<Item> findAll() {
        return List.copyOf(items);
    }

    /*public Item[] findAll() { УДАЛИТЬ
        return Arrays.copyOf(items, size);
    }*/

    public List<Item> findByName(String key) {
        List<Item> rsl = new ArrayList<>();
        for (Item item : items) {
            if (item.getName().equals(key)) {
                rsl.add(item);
            }
        }
        return rsl;
    }

    /*public Item[] findByName(String key) { УДАЛИТЬ
        Item[] rsl = new Item[size];
        int count = 0;
        for (int index = 0; index < size; index++) {
            Item item = items[index];
            if (item.getName().equals(key)) {
                rsl[count++] = item;
            }
        }
        return Arrays.copyOf(rsl, count);
    }*/

    public Item findById(int id) {
        int index = indexOf(id);
        return index != -1 ? items.get(index) : null;
    }

    /*public Item findById(int id) { УДАЛИТЬ
        int index = indexOf(id);
        return index != -1 ? items[index] : null;
    }*/

    private int indexOf(int id) {
        int rsl = -1;
        for (int index = 0; index < items.size(); index++) {
            if (items.get(index).getId() == id) {
                rsl = index;
                break;
            }
        }
        return rsl;
    }

    /*private int indexOf(int id) { УДАЛИТЬ
        int rsl = -1;
        for (int index = 0; index < size; index++) {
            if (items[index].getId() == id) {
                rsl = index;
                break;
            }
        }
        return rsl;
    }*/

    public boolean replace(int id, Item item) {
        int index = indexOf(id);
        boolean rsl = index != -1;
        if (rsl) {
            item.setId(id);
            items.set(index, item);
        }
        return rsl;
    }

    /*public boolean replace(int id, Item item) { УДАЛИТЬ
        int index = indexOf(id);
        boolean rsl = index != -1;
        if (rsl) {
            item.setId(id);
            items[index] = item;
        }
        return rsl;
    }*/

    public boolean delete(int id) {
        int index = indexOf(id);
        boolean rsl = index != -1;
        if (rsl) {
            items.remove(index);
        }
        return rsl;
    }
}


    /*public boolean delete(int id) {
        int index = indexOf(id);
        boolean rsl = index != -1;
        if (rsl) {
            System.arraycopy(items, index + 1, items, index, size - index - 1);
            items[size - 1] = null;
            size--;
        }
        return rsl;
    } */
