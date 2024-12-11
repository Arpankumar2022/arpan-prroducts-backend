package lambdaEg;

import java.util.Arrays;
import java.util.List;

public class LambdaCombinePredicates {

    public static void main(String[] args) {
        List<String> words = Arrays.asList("apple", "banana", "cherry", "date");
        words.stream().filter(word-> word.startsWith("a"));


    }
}
