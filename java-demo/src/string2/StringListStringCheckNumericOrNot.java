package string2;

import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StringListStringCheckNumericOrNot {

    public static void main(String[] args) {
        List<String> nameList = Stream.of(
                "John Doe",
                "Jane Smith",
                "927392",
                "Robert Brown",
                "Emily Davis",
                "Michael Wilson",
                "123424",
                "James Lewis",
                "Patricia Young",
                "William Hall",
                "93738292",
                "David Scott",
                "Barbara Green",
                "Richard Adams",
                "Susan Baker"
        ).collect(Collectors.toList());


        System.out.println("Without numbers from Above List " +nameList.stream()
                .filter(str -> !isNumeric(str)).toList());


    }

    private static boolean isNumeric(String str) {
        try {
            Double.parseDouble(str);
            Integer.parseInt(str);
            Float.parseFloat(str);

        } catch (Exception ex) {
            //System.out.println("throw new RuntimeException");
            return false;
        }
        return true;
    }


}
