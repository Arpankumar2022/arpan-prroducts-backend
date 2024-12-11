package optional;


import java.util.Optional;

/**
 * Optional.of()
 * Purpose: It creates an Optional that is guaranteed to hold a non-null value.
 * Usage: When you are certain that the value being wrapped is non-null.
 * Null Handling: If the provided value is null, it throws a NullPointerException.
 *
 *
 *
 */
public class OptionalOfGuaranteesToNonNull {

    public static void main(String[] args) {
        Optional<String> optional = Optional.of("Hello"); // Returns Optional containing "Hello"
        Optional<String> optionalWithNull = Optional.of(null); // Throws NullPointerException
    }
}
