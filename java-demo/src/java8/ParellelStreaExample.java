package java8;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class ParellelStreaExample {

        public static void main(String[] args) {
            List<Integer> numbers = IntStream.rangeClosed(1, 1000000).boxed().toList();

            long startTime = System.currentTimeMillis();
            List<Integer> squares = numbers.stream()
                    .map(n -> n * n)
                    .collect(Collectors.toList());
            long endTime = System.currentTimeMillis();

            System.out.println("Time taken with Stream: " + (endTime - startTime) + " ms");

    }
}
