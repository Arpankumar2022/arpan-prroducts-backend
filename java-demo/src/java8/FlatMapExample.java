package java8;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;

public class FlatMapExample {

    public static void main(String[] args) {
        List<List<Integer>> nestedList = Arrays.asList(
                Arrays.asList(1, 2),
                Arrays.asList(3, 4),
                Arrays.asList(5, 6)
        );
        //nestedList.stream().flatMap(list-> list.stream()).toList();
       System.out.println(nestedList.stream().flatMap(Collection::stream).toList());

    }
}
