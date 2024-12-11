package arrays;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

public class SecondHighestElement {

    public static void main(String[] args) {
        int[] numbers = {3, 5, 7, 2, 8, -1, 4, 10, 12};

       // Arrays.asList(numbers).stream().toList().sorted(Comparator.reverseOrder());


      System.out.println(Arrays.stream(numbers).boxed().sorted(Collections.reverseOrder()).skip(1).findFirst().get());
    }
}
