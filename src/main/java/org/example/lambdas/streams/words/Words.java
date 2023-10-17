package org.example.lambdas.streams.words;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.stream.Collectors;

public class Words {
    Map<String, Integer> wordsFrequency = new HashMap<>();
    Map<String, Integer> map = new TreeMap<>((o1, o2) -> (wordsFrequency.get(o2) - wordsFrequency.get(o1) == 0) ?
            o1.compareTo(o2) : wordsFrequency.get(o2) - wordsFrequency.get(o1));

    public String countWords(List<String> lines) {

        lines.stream()
                .map(line -> line.toLowerCase().split("[^a-zA-Zа-яА-Я]"))
                .flatMap(Arrays::stream)
                .filter(str -> str.length() >= 4)
                .forEach(this::countFrequency);
        map.putAll(wordsFrequency);
        StringBuilder finalResultString = new StringBuilder();
        map.entrySet().stream()
                .filter(entry -> entry.getValue() > 9)
                .map(entry -> entry.getKey() + " - " + entry.getValue() + "\n")
                .forEach(finalResultString::append);
        String result = finalResultString.toString();
        return result.substring(0, (finalResultString.length() - 1));
    }

    private void countFrequency(String s) {
        Integer integer = (!wordsFrequency.containsKey(s)) ?
                wordsFrequency.put(s, 1) :
                (wordsFrequency.put(s, (wordsFrequency.get(s) + 1)));
    }
}
