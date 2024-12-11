package optional;

import java.util.Optional;

public class OptionalForConditionalExecution {

    public static void main(String[] args) {
        Optional<String> optional = Optional.of("Hello, World!");

        optional.ifPresent(str ->{
            if(str.contains("World")){
                System.out.println("Contains World");
            }
        });
    }
}
