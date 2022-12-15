package ru.job4j.lambda;

import java.util.function.Supplier;

public class ScopeInside {
    public static void main(String[] args) {
        int[] coins = {1, 2, 3};
        int total = 0;
        for (int coin : coins) {
            int num = coin;
            int sum = total;
            total = add(
                    () -> sum + num
            );
        }
        System.out.println(total);
    }

    private static Integer add(Supplier<Integer> calc) {
        return calc.get();
    }
}
