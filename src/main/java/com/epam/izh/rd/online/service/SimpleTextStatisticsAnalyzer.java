package com.epam.izh.rd.online.service;

import com.epam.izh.rd.online.helper.Direction;

import java.util.*;

public class SimpleTextStatisticsAnalyzer implements TextStatisticsAnalyzer {

    @Override
    public int countSumLengthOfWords(String text) {
        List<String> words = getWords(text);
        int sumLegth = 0;
        for (String word : words) {
            sumLegth += word.length();
        }
        return sumLegth;
    }

    @Override
    public int countNumberOfWords(String text) {
        return getWords(text).size();
    }

    @Override
    public int countNumberOfUniqueWords(String text) {
        return getUniqueWords(text).size();
    }

    @Override
    public List<String> getWords(String text) {
        return new ArrayList<>(Arrays.asList(text.split("(?U)\\W+")));
    }

    @Override
    public Set<String> getUniqueWords(String text) {
        return new HashSet<>(getWords(text));
    }

    @Override
    public Map<String, Integer> countNumberOfWordsRepetitions(String text) {
        Map<String, Integer> wordsRepetitions = new HashMap<>();
        List<String> words = getWords(text);
        for (String word : words) {
            wordsRepetitions.put(word, Collections.frequency(words, word));
        }
        return wordsRepetitions;
    }

    @Override
    public List<String> sortWordsByLength(String text, Direction direction) {
        List<String> words = getWords(text);
        if (direction == Direction.ASC) {
            words.sort(Comparator.comparingInt(String::length));
        } else {
            words.sort(Collections.reverseOrder(Comparator.comparingInt(String::length)));
        }
        return words;
    }
}