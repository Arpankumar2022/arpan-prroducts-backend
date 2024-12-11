package arrays2;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class PairsWithGivenSum {

    public static void main(String[] args) {
        int[] array = {1, 5, 7, -1, 5};
        int targetSum = 6;

        Map<Integer, Integer> map = new HashMap<>();
        Map<Integer, Integer> linkedHashMap = new LinkedHashMap<>();

        for (int i = 0; i < array.length; i++) {
            if (map.containsKey(targetSum - array[i])) {
                linkedHashMap.put(array[i], targetSum - array[i]);
            } else {
                map.put(array[i], i);
            }
        }

        System.out.println(linkedHashMap);

    }
}
