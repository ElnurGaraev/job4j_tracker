package ru.job4j.oop;

public class Cat {
    public String sound() {
        String voice = "may-may";
        return voice;
    }

    private String food;

    public void show() {
        System.out.println(this.food + " for " + this.name);
    }

    public void eat(String meat) {
        this.food = meat;
    }

    private String name;

    public void giveNick(String nick) {
        this.name = nick;
    }

    public static void main(String[] args) {
        Cat peppy = new Cat();
        String say = peppy.sound();
        System.out.println("Peppy says: " + say);
        System.out.println();
        System.out.println("There are gav's food");
        Cat gav = new Cat();
        gav.eat("Kotleta");
        gav.name = "gav";
        gav.show();
        System.out.println("There are black's food");
        Cat black = new Cat();
        black.name = "black";
        black.eat("Fish");
        black.show();
    }
}
