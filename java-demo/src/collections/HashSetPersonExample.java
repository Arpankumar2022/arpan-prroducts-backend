package collections;

import java.util.HashSet;

public class HashSetPersonExample {

    public static void main(String[] args) {
        HashSet<Person>  personHashSet = new HashSet<>();
        personHashSet.add(new Person("Alice", 30));
        personHashSet.add(new Person("Bob", 25));
        personHashSet.add(new Person("Charlie", 35));
        personHashSet.add(new Person("Alice", 30));

       System.out.println(personHashSet);
    }
}
