package ru.job4j.tracker;

public class Item {
    private int id;
    private String name;

    public Item() {
    }

    public  Item(String name) {
        this.name = name;
    }

    public Item(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void print() {
        System.out.println("ID: " + id);
        System.out.println("Name: " + name);
    }

    public static void main(String[] args) {
        Item first = new Item();
        first.print();
        System.out.println();
        Item second = new Item("ABC");
        second.print();
        System.out.println();
        Item third = new Item(111, "ABCD");
        third.print();
    }
}