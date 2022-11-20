package ru.job4j.max;

public class Reduce {
    private int[] array;

    public void to(int[] rsl) {
        array = rsl;
    }

    public void print() {
        for (int index = 0; index < array.length; index++) {
            System.out.println(array[index]);
        }
    }

    public static void main(String[] args) {
        int[] rsl = {1, 2, 3};
        Reduce reduce = new Reduce();
        reduce.to(rsl);
        reduce.print();
    }
}
