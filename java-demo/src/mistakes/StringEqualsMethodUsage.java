package mistakes;

public class StringEqualsMethodUsage {

    public static void main(String[] args) {
        var str = "Hello Arpan";

        var str2 = new String("Hello Arpan");

        System.out.println(str==str2);
        System.out.println(str.equals(str2));


    }
}
