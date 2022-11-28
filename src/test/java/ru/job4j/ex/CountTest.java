package ru.job4j.ex;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

import static org.junit.Assert.*;

public class CountTest {

    @Test
    public void whenExeption() {
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class,
                () -> {
            Count.add(10, 2);
        });
        assertThat(exception.getMessage()).isEqualTo("Start should be less then finish.");
    }

    @Test
    public void whenStart1ToFinish10IsSum44() {
        int start = 0;
        int finish = 10;
        int expected = 45;
        int result = Count.add(start, finish);
        assertThat(result).isEqualTo(expected);
    }
}