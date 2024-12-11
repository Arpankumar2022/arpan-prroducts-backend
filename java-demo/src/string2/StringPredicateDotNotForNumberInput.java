package string2;

import java.util.function.Predicate;

public class StringPredicateDotNotForNumberInput {

    public static void main(String[] args) {
        String str =  "arpan12kumar";
       str.chars().mapToObj(ch-> (char)ch).toList().stream().distinct()
                .filter(Predicate.not(Character::isDigit)).sorted().forEach(System.out::print);
    }

}
