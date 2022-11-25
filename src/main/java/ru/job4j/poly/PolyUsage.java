package ru.job4j.poly;

public class PolyUsage {
    public static void main(String[] args) {
        Vehicle plane = new Plane();
        Vehicle train = new Train();
        Vehicle secondBus = new SecondBus();
        Vehicle[] vehicles = new Vehicle[]{plane, train, secondBus};
        for (Vehicle vehicle : vehicles) {
            vehicle.move();
            vehicle.refuel();
        }

    }
}
