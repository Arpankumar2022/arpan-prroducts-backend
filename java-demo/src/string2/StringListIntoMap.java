package string2;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StringListIntoMap {

    public static void main(String[] args) {
        List<String> nameList = Stream.of(
                "John Doe",
                "Jane Smith",
                "Alice Johnson",
                "Robert Brown",
                "Emily Davis",
                "Michael Wilson",
                "Mary Clark",
                "James Lewis",
                "Patricia Young",
                "William Hall",
                "Linda Wright",
                "David Scott",
                "Barbara Green",
                "Richard Adams",
                "Susan Baker",
                "1326283927"
        ).collect(Collectors.toList());

        // Map -> Length Of String , Group all strings here
        // 4, List<
        System.out.println(nameList.stream()
                .map(x -> x.replace(" ", ""))
                //.filter(x-> !isNumericOrNot(x))
                .collect(Collectors.groupingBy(a -> a.length())));

    }

   /* private static boolean isNumericOrNot(String x) {
        return Integer.parseInt(x) instanceof  Integer? true : false;
    }*/
}
