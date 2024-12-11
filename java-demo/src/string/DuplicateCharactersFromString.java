package string;

import java.util.function.Function;
import java.util.stream.Collectors;

public class DuplicateCharactersFromString {

    public static void main(String[] args) {
        String input = "programming";

       System.out.println(input.chars().mapToObj(ch-> (char)ch).toList()
                .stream().collect(Collectors.groupingBy(Function.identity(),
                        Collectors.counting())).entrySet().stream()
                .filter(obj -> obj.getValue()>1).toList());
    }
}
