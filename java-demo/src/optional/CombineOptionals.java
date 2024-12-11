package optional;

import java.util.Optional;

public class CombineOptionals {

    public static void main(String[] args) {
        Optional<String> a = Optional.of("Hello");
        Optional<String> b = Optional.of("World");
        Optional<String> result = a.flatMap(x -> b.map(y -> x + "  arpan this is added  " + y));
        result.ifPresent(System.out::println); // O/p
    }
}
