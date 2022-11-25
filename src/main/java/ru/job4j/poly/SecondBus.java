package ru.job4j.poly;

public class SecondBus implements Vehicle {

    @Override
    public void move() {
        System.out.println(getClass().getSimpleName() + " двигается по маршруту.");

    }

    @Override
    public void refuel() {
        System.out.println(getClass().getSimpleName() + " заправляется соляркой.");
    }
}
