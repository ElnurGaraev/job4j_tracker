package ru.job4j.stream;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class ProductLabel {
    public List<String> generateLabels(List<Product> products) {
        List<String> list = products.stream()
                .filter(a -> a.getStandard() - a.getActual() >= 0)
                .filter(a -> a.getStandard() - a.getActual() <= 3)
                .map(a -> new Label(a.getName(), a.getPrice()))
                .peek(a -> a.setPrice(a.getPrice() / 2))
                .map(a -> a.toString())
                .collect(Collectors.toList());
        return list;
    }
}
