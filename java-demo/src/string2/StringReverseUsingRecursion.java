package string2;

import java.util.Objects;

public class StringReverseUsingRecursion {

    public static void main(String[] args) {
        String input = "HelloWorld";
        System.out.println(reverseStringRecursion(input));
    }

    private static String reverseStringRecursion(String input) {
        if (Objects.isNull(input) || input.length() < 1)
            return input;
        return reverseStringRecursion(input.substring(1)) + input.charAt(0);
    }
}
