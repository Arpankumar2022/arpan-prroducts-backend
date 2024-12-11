package arrays;

import java.util.Arrays;

public class MaximumElementInArray {

    public static void main(String[] args) {
        int[] numbers = {3, 5, 7, 2, 8, -1, 4, 10, 12};

       System.out.println(Arrays.stream(numbers).max());
    }
}
