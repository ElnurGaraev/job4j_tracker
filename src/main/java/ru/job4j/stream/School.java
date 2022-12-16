package ru.job4j.stream;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class School {
    public List<Student> collect(List<Student> students, Predicate<Student> predict) {
        List<Student> newClass = students.stream()
                .filter(a -> predict.test(a))
                .collect(Collectors.toList());
        return newClass;
    }
}
