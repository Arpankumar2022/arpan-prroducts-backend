package string2;

public class StringRemoveDuplicateFromString {
    public static void main(String[] args) {

        String input = "Hello World".replace(" ","");
       System.out.println(input.chars().mapToObj(ch-> (char)ch).toList().stream().distinct().toList());


    }
}
