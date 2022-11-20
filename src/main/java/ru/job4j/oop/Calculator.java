package ru.job4j.oop;

import java.util.concurrent.Callable;

public class Calculator {
    private static int x = 5;

    public static int sum(int y) {
        return x + y;
    }

    public int multiply(int a) {
        return x * a;
    }

    public static int minus(int b) {
        return x - b;
    }

    public int divided(int d) {
        return d / x;
    }

    public int sumAllOperation(int e) {
        return sum(e) + multiply(e) + minus(e) + divided(e);
    }

    public static void main(String[] args) {
        int result = sum(10);
        System.out.println(result);
        System.out.println();
        Calculator calculator = new Calculator();
        int rsl = calculator.multiply(5);
        System.out.println(rsl);
        System.out.println();
        int rsl2 = minus(2);
        System.out.println(rsl2);
        System.out.println();
        int rsl3 = calculator.divided(10);
        System.out.println(rsl3);
        System.out.println();
        int total = calculator.sumAllOperation(10);
        System.out.println(total);
    }
}
