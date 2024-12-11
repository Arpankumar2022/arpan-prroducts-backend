package string;

import java.util.Arrays;
import java.util.Comparator;

public class LongestWordInString {

    public static void main(String[] args) {
        String sentence = "The quick brown fox jumps over the lazy dog";

       System.out.println(Arrays.stream(sentence.split(" "))
               .max(Comparator.comparing(String::length)));



    }
}
