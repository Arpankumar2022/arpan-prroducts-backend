package arrays;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.IntStream;

public class MissingNumbersFromListJava8 {

    public static void main(String[] args) {

        int[] arr = {1, 4, 3, 6, 8}; //o/p -> 2,5,7

        //Arrays.sort(arr);
        List<Integer> list = Arrays.stream(arr).boxed().toList();

        List<Integer> listInteger = IntStream.range(1, 8).boxed().toList();

        Set<Integer> values = new HashSet<>(listInteger);
        values.removeAll(list);
        System.out.println(values);
    }

}
