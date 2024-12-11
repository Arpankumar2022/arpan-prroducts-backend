package arrays2;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class ArraysMergingWithStream {

    public static void main(String[] args) {
        int nums1[] = {1, 2, 3, 0, 0, 0};
        int m = 3;
        int nums2[] = {2, 5, 6};
        int n = 3;
        List<Integer> list = Arrays.stream(nums1).boxed().toList().stream()
                .filter(Predicate.not(x -> Objects.equals(0, x))).collect(Collectors.toList());
        System.out.println(list);

       int[] result =  IntStream.concat(list.stream().mapToInt(x-> x), Arrays.stream(nums2)).toArray();
        Arrays.sort(result);
        for (int i : result)
            System.out.print(i +",");
    }
}
