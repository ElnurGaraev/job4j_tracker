package ru.job4j.stream;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Analyze {
    public static double averageScore(Stream<Pupil> stream) {
        return stream
                .flatMap(el -> el.subjects().stream())
                .mapToInt(Subject::scope)
                .average()
                .orElse(0D);
    }

    public static List<Tuple> averageScoreByPupil(Stream<Pupil> stream) {
        return stream
                .map(e -> new Tuple(e.name(), e.subjects()
                        .stream()
                        .mapToInt(Subject::scope)
                        .average()
                        .orElse(0D)))
                .collect(Collectors.toList());
    }

    public static List<Tuple> averageScoreBySubject(Stream<Pupil> stream) {
        return stream
                .flatMap(el -> el.subjects().stream())
                .collect(Collectors.groupingBy(Subject::name, LinkedHashMap::new, Collectors.averagingDouble(Subject::scope)))
                .entrySet()
                .stream()
                .map(el -> new Tuple(el.getKey(), el.getValue()))
                .collect(Collectors.toList());
    }

    public static Tuple bestStudent(Stream<Pupil> stream) {
        return stream
                .map(el -> new Tuple(el.name(), el.subjects()
                        .stream()
                        .mapToInt(Subject::scope)
                        .sum()))
                .max(Comparator.comparing(Tuple::score))
                .orElse(null);
    }

    public static Tuple bestSubject(Stream<Pupil> stream) {
        return stream
                .flatMap(el -> el.subjects().stream())
                .collect(Collectors.groupingBy(Subject::name, Collectors.summingDouble(Subject::scope)))
                .entrySet()
                .stream()
                .map(elem -> new Tuple(elem.getKey(), elem.getValue()))
                .max(Comparator.comparing(Tuple::score))
                .orElse(null);
    }
}
