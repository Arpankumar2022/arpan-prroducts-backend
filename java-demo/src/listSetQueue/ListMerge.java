package listSetQueue;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeSet;

public class ListMerge {

    public static void main(String[] args) {
        List<Integer> list1 = List.of(1,3,5,7,9);
        List<Integer> list2 = List.of(2,4,6,8,10);

        List<Integer> list3 = new ArrayList<>();
        list3.addAll(list1);
        list3.addAll(list2);
        //Adding each element to the TreeSet takes  0(nlogn)
        //O(logn) time (due to the properties of a Red-Black tree).
        TreeSet<Integer> treeSet = new TreeSet<>(list3);   // 0(nlogn)
        list3.clear();
        //Creating an ArrayList from a TreeSet involves iterating over all
        //𝑘
        //k elements.
        list3.addAll(treeSet);  //O(k)
        System.out.println("list of "+list3);


    }
}
