package ru.job4j.map;

import java.util.*;

public class AnalyzeByMap {
    public static double averageScore(List<Pupil> pupils) {
        double sum = 0;
        int num = 0;
        for (Pupil pupil : pupils) {
            for (Subject subject : pupil.subjects()) {
                sum += subject.score();
                num++;
            }
        }
        return sum / num;
    }

    public static List<Label> averageScoreByPupil(List<Pupil> pupils) {
        List<Label> average = new ArrayList<>();
        double sum = 0;
        for (Pupil pupil : pupils) {
            for (Subject subject : pupil.subjects()) {
                sum += subject.score();
            }
            Label label = new Label(pupil.name(), sum / pupil.subjects().size());
            average.add(label);
        }
        return average;
    }

    public static List<Label> averageScoreBySubject(List<Pupil> pupils) {
        List<Label> average = new ArrayList<>();
        LinkedHashMap<String, Integer> map = new LinkedHashMap<>();
        for (Pupil pupil : pupils) {
            for (Subject subject : pupil.subjects()) {
                map.put(subject.name(), subject.score());
                for (String name : map.keySet()) {
                    int scope = map.get(name);
                    Label label = new Label(name, scope / pupils.size());
                    average.add(label);
                }
            }
        }
        return average;
    }

    public static Label bestStudent(List<Pupil> pupils) {
        List<Label> labels = new ArrayList<>();
        double sum = 0;
        for (Pupil pupil : pupils) {
            for (Subject subject : pupil.subjects()) {
                sum += subject.score();
                Label label = new Label(pupil.name(), sum);
                labels.add(label);
            }
            labels.sort(Comparator.naturalOrder());
        }
        return labels.get(labels.size() - 1);
    }

    public static Label bestSubject(List<Pupil> pupils) {
        LinkedHashMap<String, Integer> map = new LinkedHashMap<>();
        List<Label> labels = new ArrayList<>();
        for (Pupil pupil : pupils) {
            for (Subject subject : pupil.subjects()) {
                map.put(subject.name(), subject.score());
                for (String name : map.keySet()) {
                    int score = map.get(name);
                    Label label = new Label(name, score);
                    labels.add(label);
                }
                labels.sort(Comparator.naturalOrder());
            }
        }
        return labels.get(labels.size() - 1);
    }
}

