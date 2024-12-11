package optional;

import java.util.Optional;

public class OptionalAndExceptionHandling {

    public static void main(String[] args) {
        Optional<Integer> result = divide(10, 0);
        System.out.println(result.orElse(-1));
    }

    public static Optional<Integer> divide(int a, int b) {
        try {
            return b == 0 ? Optional.empty() : Optional.of(a / b);
        } catch (ArithmeticException e) {
            return Optional.empty();
        }
    }
}
