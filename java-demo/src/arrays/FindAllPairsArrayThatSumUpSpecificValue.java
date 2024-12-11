package arrays;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class FindAllPairsArrayThatSumUpSpecificValue {

    public static void main(String[] args) {
        int[] array = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        int targetSum = 10;

        Map<Integer, Integer> map = new HashMap<>();
        Map<Integer, Integer> map2 = new LinkedHashMap<>();

        for (int i=0 ;i<array.length; i++){
           if(!map.containsKey(targetSum-array[i])){
               map.put(array[i],targetSum-array[i]);
           }
        }

        System.out.println(map);
    }
}
