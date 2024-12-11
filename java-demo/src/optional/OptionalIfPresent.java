package optional;

import java.util.Optional;

public class OptionalIfPresent {

    public static void main(String[] args) {
        /**
         * ifPresent always takes one Consumer to do some task on accept method to work on the response
         */
        Optional.of("Hello").ifPresent(str-> System.out.println(str));
    }
}
