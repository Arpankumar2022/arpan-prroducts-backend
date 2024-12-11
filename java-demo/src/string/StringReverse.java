package string;

import java.util.Arrays;

public class StringReverse {


    public static void main(String[] args) {
        String[] stringArray = {"apple", "banana", "cherry", "date"};

       // System.out.println(Arrays.stream(stringArray)
         //       .map(word-> new StringBuilder(word).reverse()).toList());

        Arrays.stream(stringArray)
                .map(word-> new StringBuilder(word).reverse()).toArray(String[]::new);



    }
}
