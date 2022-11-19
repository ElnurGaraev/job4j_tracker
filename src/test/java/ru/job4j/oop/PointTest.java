package ru.job4j.oop;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

import static org.junit.Assert.*;

public class PointTest {

    @Test
    public void when00To20Then2() {
        Point a = new Point(0, 0);
        Point b = new Point(2, 0);
        double rsl = a.distance(b);
        double expected = 2;
        assertThat(rsl).isEqualTo(expected);
    }

    @Test
    public void when30To00Then3() {
        Point a = new Point(3, 0);
        Point b = new Point(0, 0);
        double rsl = a.distance(b);
        double expected = 3;
        assertThat(rsl).isEqualTo(expected);
    }

    @Test
    public void when01To00Then1() {
        Point a = new Point(0, 1);
        Point b = new Point(0, 0);
        double rsl = a.distance(b);
        double expected = 1;
        assertThat(rsl).isEqualTo(expected);
    }

    @org.junit.Test
    public void when00To04Then4() {
        Point a = new Point(0, 0);
        Point b = new Point(0, 4);
        double rsl = a.distance(b);
        double expected = 4;
        assertThat(rsl).isEqualTo(expected);
    }
}