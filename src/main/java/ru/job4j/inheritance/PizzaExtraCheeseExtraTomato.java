package ru.job4j.inheritance;

public class PizzaExtraCheeseExtraTomato extends PizzaExtraCheese {
    private static final String EXTRA_TOMATO = "Extra tomato";

    public String name() {
        return super.name() + " and " + EXTRA_TOMATO;
    }
}
