package collectorsToMap;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class ToMapExample5 {


    public static void main(String[] args) {
        List<String> words = Arrays.asList("apple", "banana", "cherry");
        System.out.println("++++"+words.stream().collect(Collectors.toMap(
                word -> word.length(),
                word-> word )));
        // o/p --Map length, String
    words.stream().collect(Collectors.toMap(
                String::length,
                word -> word,
             (existing, replacement) -> {
                 // Custom merge logic
                 System.out.println("Merging: " + existing + " with " + replacement);
                 return existing;
             }
        )).entrySet().forEach(obj-> System.out.println(obj.getKey()+" ---- " +obj.getValue()));








    }

}
