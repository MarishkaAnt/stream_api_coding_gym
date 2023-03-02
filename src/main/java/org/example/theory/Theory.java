package org.example.theory;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
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
    public static void streamExample() {
        List.of("a1", "a2", "a3")
                .stream()
                .findFirst()
                .ifPresent(System.out::println);
    }

    /**
     * (?) Какие терминальные операции вам уже знакомы и использовались вами в коде?
     */
    public static void terminalOperationExample() {
        System.out.println("=====Terminal=====");

        Stream<String> stream1 = getStreamOfString();
        Optional<String> any = stream1.findAny();
        System.out.println(any);

        Stream<String> stream2 = getStreamOfString();
        boolean allMatch = stream2.allMatch(e -> e.startsWith("b"));
        System.out.println(allMatch);

        Stream<String> stream3 = getStreamOfString();
        boolean anyMatch = stream3.anyMatch(e -> e.startsWith("b"));
        System.out.println(anyMatch);

        Stream<String> stream4 = getStreamOfString();
        boolean noneMatch = stream4.noneMatch(e -> e.startsWith("b"));
        System.out.println(noneMatch);

        Stream<String> stream5 = getStreamOfString();
        List<String> collect = stream5.collect(Collectors.toList());

        //Void
        collect.forEach(s -> System.out.print(s + " "));
        System.out.println(" ");
        System.out.println("===IntStream===");

        // (?) Почему я создаю новый стрим каждый раз?

        IntStream intStream1 = getStreamOfInts();
        OptionalInt max = intStream1.max();
        System.out.println(max);

        IntStream intStream2 = getStreamOfInts();
        OptionalInt min = intStream2.min();
        System.out.println(min);

        IntStream intStream3 = getStreamOfInts();
        long count = intStream3.count();
        System.out.println(count);

        IntStream intStream4 = getStreamOfInts();
        int sum = intStream4.sum();
        System.out.println(sum);

        IntStream intStream5 = getStreamOfInts();
        OptionalInt reduce1 = intStream5.reduce((e1, e2) -> e1 * e2);
        IntStream intStream6 = getStreamOfInts();
        int reduce2 = intStream6.reduce(3, (e1, e2) -> (e1 * e2));
        System.out.println(reduce1 + ", " + reduce2);

    }

    /**
     * Промежуточные операции выполняются только при наличии терминальной.
     * (?) Какие промежуточные операции вам уже знакомы и использовались вами в коде?
     *
     * Внимательно следите за порядком вызываемых операций. Правильный порядок способен
     * в разы оптимизировать затраты на вычисления.
     * Каждый элемент проходит цепочку методов "вертикально", а не "горизонтально".
     * (?) Существуют ли исключения?
     */
    public static void intermediateOperation() {
        System.out.println("=====Intermediate=====");

        Stream<String> stringStream1 = getStreamOfString();
        List<String> collect = stringStream1
                .peek(System.out::println)
                .distinct()
                .peek(System.out::println)
                .map(String::toUpperCase)
                .peek(System.out::println)
                .skip(1)
                .peek(System.out::println)
                .filter(e -> e.startsWith("A"))
                .peek(System.out::println)
                .collect(Collectors.toList());

        System.out.println("After all operations: ");
        System.out.println(collect);

        Stream<String> stringStream2 = getStreamOfString();
        stringStream2
                .sorted(Comparator.reverseOrder())
                .flatMap(e -> Arrays.stream(e.split("")))
                .forEachOrdered(x -> System.out.print(x + " "));
    }

    private static Stream<String> getStreamOfString() {
        return Stream.of("a0", "a1", "a1", "a2", "a3", "k", "b2", "c3");
    }

    private static IntStream getStreamOfInts() {
        return IntStream.range(1, 5);
    }

}
