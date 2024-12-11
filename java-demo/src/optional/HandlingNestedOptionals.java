package optional;

import collections.Address;
import collections.User;

import java.util.Optional;

public class HandlingNestedOptionals {

    /**
     * Optional is a container object to hold a  value or not
     *
     *
     *
     * @param args
     */

    public static void main(String[] args) {
       // Optional<String> addressCit = Optional.of("New York");
        User  user = new User(Optional.of(new Address(Optional.of("New York"))));
        System.out.println(user.getAddress().flatMap(Address::getCity).orElse("Unknown"));

    }
}
