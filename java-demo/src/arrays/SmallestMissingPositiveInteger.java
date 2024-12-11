package arrays;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.IntStream;

public class SmallestMissingPositiveInteger {
    public static int findSmallestMissingPositive(int[] A) {
        // Step 1: Filter out non-positive numbers and add the rest to a set
        /**
         * HashSet::new: Provides a new HashSet to collect the elements.
         * HashSet::add: Adds each positive integer to the HashSet.
         * HashSet::addAll: Combines two HashSet instances, which can occur in parallel stream processing.
         */

        /**
         * Supplier (HashSet::new): Creates a new HashSet.
         * Accumulator (HashSet::add): Adds elements to the HashSet.
         * Combiner (HashSet::addAll): Merges two HashSet instances.        *
         *
         */

        Set<Integer> positiveSet = IntStream.of(A)
                .filter(x -> x > 0)
                .collect(HashSet::new, HashSet::add, HashSet::addAll);

        // Step 2: Check for the smallest positive integer missing
        int smallestPositive = 1;
        while (positiveSet.contains(smallestPositive)) {
            smallestPositive++;
        }

        return smallestPositive;
    }

    public static void main(String[] args) {
       // int[] A = {1, 3, 6, 4, 1, 2};
       // int[] A = {1,2,3};
        int[] A = {-1, -3};
        System.out.println(findSmallestMissingPositive(A));  // Output: 5
    }
}
