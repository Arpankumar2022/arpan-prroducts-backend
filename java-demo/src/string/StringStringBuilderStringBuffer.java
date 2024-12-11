package string;

public class StringStringBuilderStringBuffer {

    public static void main(String[] args) {

        String s1 = "Hello";

        //  Not Thread Safe
        StringBuilder stringBuilder = new StringBuilder("StringBuilder Hello");

        // Thread Safe and  synchronized
        StringBuffer stringBuffer = new StringBuffer("StringBuffer Hello");

        stringBuffer.append(" Arpan");
       // stringBuffer.reverse();
        s1.concat(" Arpan");
        stringBuilder.append(" Arpan");
       // stringBuilder.reverse();
        System.out.println(stringBuffer);
       //   System.out.println(s1);



         // ***************************************************** //
        /*** Converting StringBuffer to StringBuilder and StringBuilder to StringBuffer ******/
        // ******************************************************//
        // Creating object of StringBuffer class and
        // passing our input string to it
        StringBuffer sbr = new StringBuffer("Geeks");

        // Storing value StringBuffer object in String and
        // henceforth converting StringBuffer object to
        // StringBuilder class
        String str = sbr.toString();
        StringBuilder sbl = new StringBuilder(str);

        // Printing the StringBuilder object on console
        System.out.println(sbl);

    }
}
