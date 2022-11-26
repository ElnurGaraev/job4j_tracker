package ru.job4j.poly;

public class Bus implements Transport {
    @Override
    public void drive() {
        System.out.println("Bus is coming");
    }

    @Override
    public void passengers(int numbers) {
        System.out.println("There are " + numbers + " on the bus.");
    }

    @Override
    public float refuel(float quantity) {
        float prise = 50;
        if (quantity != 0) {
            prise *= quantity;
        }
        return prise;
    }
}
