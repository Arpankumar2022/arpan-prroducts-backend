package mistakes;

import collections.Person;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class OptionalsExamplesAll {

    /***
     * The Optional class in Java 8 is a container object which may or may not contain a non-null value.
     * It is a way to avoid NullPointerException and
     * provides a more expressive way to handle optional values.
     */

    private static Map<String, Person> perMap = new HashMap<>();
    private static Map<String, Person> initMap = new HashMap<>();

     private static Map<String, Person> getPerson() {
          perMap.put("Engineer", new Person("Alice", 30));
          perMap.put("Designer", new Person("Bob", 25));
          perMap.put("Manager", new Person("Charlie", 35));
          perMap.put("Dancer", new Person("David", 30));
          perMap.put("Docter", new Person("Jos", 31));
          perMap.put("Police", new Person("Buttler", 30));
          return perMap;
      }

    public static void main(String[] args) {

        /**
         * Optional is a container
         */
        initMap=getPerson();
        String[] strArr = {"Engineer","Designer","Manager","Docter","Mechanic","Dancer"};

        /**
         *    Usage of ifPresent  and
         *    Optional.ofNullable to prevent from Null pointer exception
         */
        System.out.println(initMap.get("Mechanic"));
        Arrays.stream(strArr).forEach(str-> Optional.ofNullable(initMap.get(str)).ifPresent(per->{
            System.out.println(per);
        }));

        /**
         * Usage of Optional.of
         */



    }
}
