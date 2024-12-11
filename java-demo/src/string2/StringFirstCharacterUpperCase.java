package string2;

import java.util.Arrays;
import java.util.stream.Collectors;

public class StringFirstCharacterUpperCase {
    public static void main(String[] args) {
        String input = "hello world from java";
        // o/p - Hello World From Java
        //input.replace(" ","")
        StringBuilder stringBuilder = new StringBuilder("");
        Arrays.stream(input.split(" ")).collect(Collectors.toList()).forEach(x-> {
            stringBuilder.append(x.substring(0,1).toUpperCase()+x.substring(1)).append(" ");
        });

     System.out.println(stringBuilder);


       /* Arrays.stream(input.split(" ")).map(word -> {
            word.charAt(0)
        })*/





        String result = Arrays.stream(input.split(" "))
                .map(word -> word.substring(0, 1).toUpperCase() + word.substring(1))
                .collect(Collectors.joining(" "));
       // System.out.println(result);
    }
}
