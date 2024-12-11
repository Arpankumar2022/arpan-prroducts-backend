package string2;

public class StringReverse {
    public static void main(String[] args) {
        String input = "Hello Arpan".replace(" ","");
        StringBuilder stringBuilder = new StringBuilder(input).reverse();
        System.out.println(stringBuilder);

    }
}
