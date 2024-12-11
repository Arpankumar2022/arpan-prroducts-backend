package string;

import java.util.function.Function;
import java.util.stream.Collectors;

public class CountFrequencyCharactersInString {
    public static void main(String[] args) {
        String input = "hello world";
        //String input1 = input.replace(" ", "");
        //System.out.println(input1);
        System.out.println(input.replace(" ", "")
                .chars().mapToObj(ch-> (char)ch).toList()
                .stream()
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting())));

    }

}
