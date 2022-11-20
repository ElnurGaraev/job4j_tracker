package ru.job4j.condition;

public class Max {
    public static int max(int first, int second) {
        return first > second ? first : second;
    }

    public static int max(int first, int second, int third) {
        return max(first, max(second, third));
    }

    public static int max(int first, int second, int third, int fours) {
        return max(first, max(second, third, fours));
    }

    public static long max(long first, long second) {
        return first > second ? first : second;
    }
}
