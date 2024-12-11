package string2;

import java.util.Collections;
import java.util.List;

public class StringFirstNonRepeatedCharacter {

    public static void main(String[] args) {
        String input = "swwiss";
        List<Character> list = input.chars().mapToObj(ch -> (char) ch).toList();
        System.out.println(list.stream().filter(x -> Collections.frequency(list, x) == 1).findFirst().get());


    }
}
