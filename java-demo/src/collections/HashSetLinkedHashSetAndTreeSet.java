package collections;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.TreeSet;

public class HashSetLinkedHashSetAndTreeSet {

    public static void main(String[] args) {
        HashSet<String> hashSet = new HashSet<>();

        // Adding elements to the HashSet
        hashSet.add("Apple");
        hashSet.add("Banana");
        hashSet.add("Cherry");
        hashSet.add("Date");
        hashSet.add("Elderberry");

        LinkedHashSet<String> linkedHashSet = new LinkedHashSet<>();

        // Adding elements to the LinkedHashSet
        linkedHashSet.add("Apple");
        linkedHashSet.add("Banana");
        linkedHashSet.add("Cherry");
        linkedHashSet.add("Date");
        linkedHashSet.add("Elderberry");

        TreeSet<String> treeSet = new TreeSet<>();

        // Adding elements to the TreeSet
        treeSet.add("Apple");
        treeSet.add("1Banana");
        treeSet.add("elderberry");
        treeSet.add("Cherry");
        treeSet.add("Date");



        System.out.println(hashSet);
        System.out.println(linkedHashSet);
        System.out.println(treeSet);


    }
}
