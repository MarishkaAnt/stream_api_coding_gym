package org.example;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Stream;

/**
 * Создание стримов
 */
public class StreamCreation extends Theory {

    public static void createStreams() {
        Collection<String> collection = List.of("a1", "a2", "a3");
        Stream<String> streamFromCollection = collection.stream();
        Stream<String> streamFromValues = Stream.of("a1", "a2", "a3");
        String[] array = {"a1", "a2", "a3"};
        Stream<String> streamFromArrays = Arrays.stream(array);

        //Stream<String> streamFromFiles = Files.lines(Paths.get("file.txt"));

        Stream<Integer> streamFromIterate = Stream.iterate(1, n -> n + 1);
        //streamFromIterate.forEach(System.out::println);
        //streamFromIterate.takeWhile(e -> e == 5).forEach(System.out::println);
        Stream<String> streamFromGenerate = Stream.generate(() -> "a1");
        //streamFromGenerate.forEach(System.out::println);
        //streamFromGenerate.limit(5).forEach(System.out::println);
    }
}
