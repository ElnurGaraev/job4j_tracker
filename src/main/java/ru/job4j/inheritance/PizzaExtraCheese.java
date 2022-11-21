package ru.job4j.inheritance;

public class PizzaExtraCheese extends Pizza {
    private static final String EXTRA_CHEESE = "Extra cheese";

    @Override
    public String name() {
        return super.name() + " and " + EXTRA_CHEESE;
    }
}
