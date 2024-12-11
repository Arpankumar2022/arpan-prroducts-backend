package arrays;

import java.util.Arrays;
import java.util.Set;
import java.util.TreeSet;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class MergeSortedArrays {

    public static void main(String[] args) {
        int[] array1 = {1, 3, 5, 7};
        int[] array2 = {2, 4, 6, 8};

        Set<Integer> treeSet = new TreeSet<>();
        treeSet.addAll((Arrays.stream(array1).boxed().toList()));
        treeSet.addAll((Arrays.stream(array2).boxed().toList()));
        System.out.println(treeSet);

        System.out.println("Merged Sorted Array: " +IntStream.concat(Arrays.stream(array1),
                Arrays.stream(array2)).sorted().toArray());

        //IntStream.concat(Arrays.stream(array1),)


    }
}
