package optional;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class OptionalWithStreams {

    public static void main(String[] args) {

        List<String> words = Arrays.asList("apple", "banana", "cherry");

        System.out.println(words.stream().max(Comparator.comparing(String::length)));
        System.out.println(words.stream().min(Comparator.comparing(String::length)));


    }
}
