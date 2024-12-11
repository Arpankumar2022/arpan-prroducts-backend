package string;

import java.util.Arrays;
import java.util.stream.Collectors;

public class ReverseEachWordSentence {

    public static void main(String[] args) {
        String sentence = "The quick brown fox";
        //fox The quick brown ";
        StringBuilder strBr = new StringBuilder();
        System.out.println(Arrays.stream(sentence.split(" ")).map(word-> new StringBuilder(word).reverse().toString())
                        .collect(Collectors.joining(" ")));

        //System.out.println(strBr);


    }
}
