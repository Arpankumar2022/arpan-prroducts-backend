package arrays;

import java.util.Arrays;

public class RemoveDuplicatesFromArray {

    public static void main(String[] args) {
        Integer[] array = {3, 5, 7, 3, 8, 7};

        Arrays.stream(array).distinct().forEach(System.out::println);



    }
}
