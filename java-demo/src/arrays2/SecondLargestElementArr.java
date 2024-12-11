package arrays2;

import java.util.Arrays;
import java.util.Comparator;

public class SecondLargestElementArr {

    public static void main(String[] args) {
        int[] array = {3, 5, 7, 2, 8, 5, 6, 8, 9};  // 8
        Arrays.stream(array).max().getAsInt();
        System.out.println(Arrays.stream(array).boxed()
                .sorted(Comparator.reverseOrder()).skip(1).findFirst().get());

    }
}
