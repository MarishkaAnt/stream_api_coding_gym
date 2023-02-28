package org.example;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Теория по Stream API
 */
public class Theory {

    /**
     * Stream представляет собой поток элементов и различные методы
     * для работы с ними.
     * Методы потоков бывают промежуточными (intermediate) и терминальными (terminal).
     * Промежуточные методы возвращают поток, что позволяет последовательно вызывать множество таких методов.
     * Терминальные методы либо не возвращают значения (void) либо возвращают результат типа отличного от потока.
     * Например:
     */
    public void streamExample() {
        List.of("a1", "a2", "a3")
                .stream()
                .findFirst()
                .ifPresent(System.out::println);
    }

    /**
     * (?) Какие терминальные операции вам уже знакомы и использовались вами в коде?
     */
    public void terminalOperationExample() {

        Stream<String> stream1 = getStreamOfString();
        stream1.findAny()
                .ifPresent(System.out::println);

        Stream<String> stream2 = getStreamOfString();
        boolean allMatch = stream2
                .allMatch(e -> e.startsWith("b"));

        Stream<String> stream3 = getStreamOfString();
        boolean anyMatch = stream3
                .anyMatch(e -> e.startsWith("b"));

        Stream.of("a1", "a2", "a3")
                .forEach(System.out::println);

        List<String> collect = Stream.of("a1", "a2", "a3")
                .collect(Collectors.toList());

        // (?) Почему я создаю новый стрим каждый раз?

    }

    /**
     * (?) Какие промежуточные операции вам уже знакомы и использовались вами в коде?
     */
    public void intermediateOperation() {

    }

    private Stream<String> getStreamOfString() {
        return Stream.of("a1", "a2", "b3");
    }
}
