package ru.job4j.tracker;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.offset;

import static org.junit.Assert.*;

public class ItemDescByNameTest {

    @Test
    public void compare() {
        List<Item> items = Arrays.asList(
                new Item("Test2"),
                new Item("Test1"),
                new Item("Test3"),
                new Item("Test5"),
                new Item("Test4")
        );
        items.sort(new ItemDescByName());
        List<Item> expected = Arrays.asList(
                new Item("Test5"),
                new Item("Test4"),
                new Item("Test3"),
                new Item("Test2"),
                new Item("Test1")
        );
        assertThat(items).isEqualTo(expected);
    }
}