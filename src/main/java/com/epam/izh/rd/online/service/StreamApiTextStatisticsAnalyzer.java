package com.epam.izh.rd.online.service;

import com.epam.izh.rd.online.helper.Direction;

import java.util.*;
import java.util.stream.Collectors;

public class StreamApiTextStatisticsAnalyzer implements TextStatisticsAnalyzer {
    @Override
    public int countSumLengthOfWords(String text) {
        return Arrays.stream(text.split("(?U)\\W+")).mapToInt(String::length).sum();
    }

    @Override
    public int countNumberOfWords(String text) {
        return (int) Arrays.stream(text.split("(?U)\\W+")).count();
    }

    @Override
    public int countNumberOfUniqueWords(String text) {
        return Arrays.stream(text.split("(?U)\\W+")).collect(Collectors.toSet()).size();
    }

    @Override
    public List<String> getWords(String text) {
        return Arrays.stream(text.split("(?U)\\W+")).collect(Collectors.toList());
    }

    @Override
    public Set<String> getUniqueWords(String text) {
        return Arrays.stream(text.split("(?U)\\W+")).collect(Collectors.toSet());
    }

    @Override
    public Map<String, Integer> countNumberOfWordsRepetitions(String text) {
        return Arrays.stream(text.split("(?U)\\W+")).collect(Collectors.toMap(k -> k, k -> 1, (a, b) -> a + 1));
    }

    @Override
    public List<String> sortWordsByLength(String text, Direction direction) {
        List<String> words;
        if (direction == Direction.ASC) {
            words = Arrays.stream(text.split("(?U)\\W+"))
                    .sorted(Comparator.comparingInt(String::length))
                    .collect(Collectors.toList());
        } else {
            words = Arrays.stream(text.split("(?U)\\W+"))
                    .sorted(Collections.reverseOrder(Comparator.comparingInt(String::length)))
                    .collect(Collectors.toList());
        }
        return words;
    }
}