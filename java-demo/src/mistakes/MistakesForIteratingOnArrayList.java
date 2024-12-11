package mistakes;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class MistakesForIteratingOnArrayList {

    public static void main(String[] args) {


        //  A Java Cursor is an Iterator,
        //  that is used to iterate or traverse or retrieve a Collection or
        //  Stream object's elements one by one.

        List<String> arrayList = new ArrayList<>
                (Arrays.asList("redmi", "vivo", "samsung","micromax", "nokia", "neo" , "window"));


       /* arrayList.forEach(product -> {
            if (product.equals("micromax")) {
                arrayList.remove(product);
            }
        });*/

        System.out.println(arrayList);
       // First Approach
      /*  Iterator<String>   iterator =  arrayList.iterator();
       while(iterator.hasNext()){
           String word = iterator.next();
           if (word.equals("micromax")) {
               iterator.remove();
           }
      }*/

       // Second Approach
        arrayList.removeIf(word -> word.equals("micromax"));



    System.out.println(arrayList);

    }
}
