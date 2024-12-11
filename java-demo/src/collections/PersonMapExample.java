package collections;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class PersonMapExample {

    public static void main(String[] args) {
        Map<Person, String> map = new HashMap<>();
        map.put(new Person("Alice", 30), "Engineer");
        map.put(new Person("Bob", 25), "Designer");
        map.put(new Person("Charlie", 35), "Manager");
        map.put(new Person("Alice", 30), "Engineer");

        map.forEach((person, job)->{
           System.out.println(person+"and   "+job);
        });

        map.entrySet().stream().filter(obj-> obj.getKey().age>30).collect(Collectors.toList())
                .forEach((obj)->{
                  //  System.out.println(obj);
                });


    }
}
