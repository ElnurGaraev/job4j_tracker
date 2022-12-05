package ru.job4j.tracker;

import static java.lang.System.out;

public class ExitAction implements UserAction {
    private final Output out;

    public ExitAction(Output out) {
        this.out = out;
    }

    @Override
    public String name() {
        return "Exit program";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        out.println("=== Exit program ===");
        return false;
    }
}
