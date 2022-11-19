package ru.job4j.oop;

public class Error {
    private boolean active;
    private int status;
    private  String message;

    public Error() {
    }

    public Error(boolean active, int status, String message) {
        this.active = active;
        this.status = status;
        this.message = message;
    }

    public void printInfo() {
        System.out.println("Active: " + active);
        System.out.println("Status: " + status);
        System.out.println("Message: " + message);
    }

    public static void main(String[] args) {
        Error error = new Error();
        error.printInfo();
        System.out.println();
        Error info = new Error(true, 1, "ок");
        info.printInfo();
        System.out.println();
        Error computer = new Error(false, 907, "system problem");
        computer.printInfo();
        System.out.println();
        Error system = new Error(false, 700, "restart computer");
        system.printInfo();
    }
}
