package oops;

public class StaticAndIntialise {

    static {
        System.out.println("this is static block..");
    }

    {
        System.out.println("this is initialise block..");
    }


    public static void main(String[] args) {
        StaticAndIntialise str= new StaticAndIntialise();
    }
}
