package string2;

import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class StringTwoAnargram {

    public static void main(String[] args) {
        String str1 = "listen";
        String str2 = "silent";

        String str3 = "arpan";
        String str4 = "arpnat";


        System.out.println(checkStringsAreAnargramOrNot(str1, str2));
        System.out.println(checkStringsAreAnargramOrNot(str3, str4));


    }

    private static boolean checkStringsAreAnargramOrNot(String str1, String str2) {
        return sortedList(str1).equals(sortedList(str2));
    }

    private static List<Character> sortedList(String str) {
        return str.chars().mapToObj(x -> (char) x).sorted().collect(Collectors.toList());

    }
}
