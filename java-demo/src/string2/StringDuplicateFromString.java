package string2;

import java.util.Collections;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

public class StringDuplicateFromString {
    public static void main(String[] args) {
        String input = "arpankumarsrivastava";

        List<Character> list = input.chars().mapToObj(ch -> (char) ch).toList();
        //System.out.println(list.stream().filter(x -> Collections.frequency(list, x) > 1)
        //        .collect(Collectors.groupingBy(Function.identity(), Collectors.counting())));

        // Count Frequency of Characters in String
        System.out.println(list.stream().peek(System.out::print)
                .collect(Collectors.groupingBy(Function.identity(),Collectors.counting())));

    }
}
