package lambdaEg;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class MappingObjectsDifferentTypes {
    public static void main(String[] args) {
        List<String> words = Arrays.asList("apple", "banana", "cherry");
        System.out.println(words.stream().map(String::length).collect(Collectors.toList()));
    }
}
