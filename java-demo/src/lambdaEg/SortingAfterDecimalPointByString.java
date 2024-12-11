package lambdaEg;

import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class SortingAfterDecimalPointByString {
    public static void main(String[] args) {
        List<Double> listDouble = List.of(10.980,20.789,11.987,45.21);
        Map<String,Double> map = new TreeMap<>();
        listDouble.forEach(dbl-> {
            int indexVal= dbl.toString().indexOf(".");
            map.put(dbl.toString().substring(indexVal),dbl);
        });

       map.entrySet().forEach(obj-> {
           System.out.println(obj.getValue());
       });
    }
}
