package string2;

import java.util.Arrays;

public class StringVowelConsonantsCount {

    public static void main(String[] args) {
        String input = "Hello World".replace(" ","");
       System.out.println("Number Of Consonants "+input.chars().mapToObj(Character::toString).map(String::toUpperCase).toList().stream()
               .distinct().filter(x-> !Arrays.asList("A","E","I","O","U").contains(x)).toList().size());
        System.out.println("Number Of Vowels "+input.chars().mapToObj(Character::toString).map(String::toUpperCase).toList().stream()
                .distinct().filter(x-> Arrays.asList("A","E","I","O","U").contains(x)).toList().size());





    }
}
