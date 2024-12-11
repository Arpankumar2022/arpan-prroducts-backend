package string2;

import java.util.Objects;

public class StringPalindrome {
    public static void main(String[] args) {
        String input = "madam";

        StringBuilder stringBuilder = new StringBuilder(input);

        if(Objects.equals(stringBuilder.reverse(), stringBuilder)){
           System.out.println("its palindrome");
        }

    }
}
