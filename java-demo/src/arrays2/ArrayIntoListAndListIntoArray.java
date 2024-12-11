package arrays2;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class ArrayIntoListAndListIntoArray {

    public static void main(String[] args) {
        int[] array = {1, 5, 7, -1, 5};
        /**
         * Array into List<Integer>
         */
        Arrays.stream(array).boxed().toList();


        /**
         * List into Array
         */

        List<Integer> list = Stream.of(2,4,21,45,56,3,22,24,28,41,62,67).toList();
       int[] result =   list.stream().mapToInt(x->x).toArray();
       for (int i : result){
           System.out.print(i+" ");
       }

    }
}
