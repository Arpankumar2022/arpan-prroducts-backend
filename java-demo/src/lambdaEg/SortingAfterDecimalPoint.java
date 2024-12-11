package lambdaEg;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class SortingAfterDecimalPoint {
    public static void main(String[] args) {
        List<Double>  listDouble = List.of(10.980,20.789,11.987,45.21,09.980);
        Map<BigDecimal,Double> map = new TreeMap<>();
        listDouble.forEach(dbl->{
            BigDecimal bigDecimal = new BigDecimal(String.valueOf(dbl));
            int intValue = bigDecimal.intValue();
            map.put(bigDecimal.subtract(new BigDecimal(intValue)),dbl);

        });
        map.entrySet().forEach(obj-> {
            System.out.println(obj.getValue());
        });

        // o/p-  11.987,10.980,20.789,45.210
    }
}
