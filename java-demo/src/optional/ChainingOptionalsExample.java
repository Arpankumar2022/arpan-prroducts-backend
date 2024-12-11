package optional;

import java.util.Optional;

public class ChainingOptionalsExample {
    /**
     *
     * Optional is a container object which may or may not contain a non-null value.
     * If a value is present, isPresent() returns true.
     * If no value is present, the object is considered empty and isPresent() returns false.
     * Additional methods that depend on the presence or absence of a contained value are provided,
     * such as orElse() (returns a default value if no value is present) and ifPresent()
     * (performs an action if a value is present).
     *
     * @param args
     */
    public static void main(String[] args) {
        Optional<String> optional = Optional.of("Hello, World!");
        optional.ifPresent(obj-> System.out.println(obj));

        System.out.println(optional.map(String::toLowerCase)
                .filter(ch-> ch.contains("e"))
                .map(ch-> ch.replace("o","m"))
                .orElse("arpan"));
    }
}
