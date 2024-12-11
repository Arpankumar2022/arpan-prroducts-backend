package lambdaEg;

import collections.Person;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class SortingListCustomObjects {

    public static void main(String[] args) {


        List<Integer>  list = Arrays.stream(new int[]{1, 45, 3, 32, 23, 66, 21}).boxed().toList();
        list.stream().sorted(Comparator.reverseOrder()).forEach(obj-> System.out.println(obj));
        System.out.println("Asc");
        list.stream().sorted().forEach(obj-> System.out.println(obj));

        List<Person> people = Arrays.asList(
                new Person("Alice", 30),
                new Person("Bob", 25),
                new Person("Charlie", 35)
        );

        people.stream().sorted(Comparator.comparingInt(Person::getAge).reversed()).forEach(obj->{
            System.out.println(obj);
        });


    }
}
