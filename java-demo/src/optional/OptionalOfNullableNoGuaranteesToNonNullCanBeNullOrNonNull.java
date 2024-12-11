package optional;


import java.util.Optional;

/**
 * Optional.ofNullable() -- ma contain null values or does not contain null values
 * Purpose: It creates an Optional that can hold a value that might be null.
 * Usage: When the value being wrapped might be null.
 * Null Handling: If the provided value is null, it returns Optional.empty().
 * If the provided value is non-null, it returns an Optional containing the value.
 */
public class OptionalOfNullableNoGuaranteesToNonNullCanBeNullOrNonNull {

    public static void main(String[] args) {

        Optional<String> optional = Optional.ofNullable(null); // Returns Optional.empty()
        Optional<String> optionalWithValue = Optional.ofNullable("Hello"); // Return some values
    }
}
