package string;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class GroupAnagrams {

    public static void main(String[] args) {
        List<String> words = Arrays.asList("listen", "silent", "enlist", "rat", "tar", "art");
       List<List<String>>  list = new ArrayList<>();
       List<String>  lst = new ArrayList<>();

       System.out.println(words.stream().collect(Collectors.groupingBy(word-> {
            char[] chars = word.toCharArray();
            Arrays.sort(chars);
            return new String(chars);
        })));



    }


}
