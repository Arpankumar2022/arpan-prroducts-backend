package arrays2;

import java.util.Arrays;
import java.util.stream.IntStream;

public class MaxElementFromArray {

    public static void main(String[] args) {
        int[] numbers = {3, 5, 7, 2, 8, -1, 4, 10, 12};

        System.out.println(IntStream.of(numbers).max().getAsInt());

        System.out.println(Arrays.stream(numbers).max().getAsInt());


    }
}
