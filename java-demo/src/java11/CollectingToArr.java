package java11;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class CollectingToArr {

    public static void main(String[] args) {
        List<String> sampleList = Arrays.asList("Java", "Kotlin");
        String [] sampleArray =  sampleList.toArray(String[]::new);

    }
}
