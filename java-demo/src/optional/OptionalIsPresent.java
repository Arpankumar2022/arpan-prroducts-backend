package optional;

import java.util.Optional;

public class OptionalIsPresent {

    public static void main(String[] args) {
        System.out.println(Optional.of("Hello").isPresent());
        System.out.println(Optional.ofNullable(null).isPresent());
    }
}
