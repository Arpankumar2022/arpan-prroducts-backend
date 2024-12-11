package staticdefault;

public interface Inter3 extends Inter1{
    default void show(){
        System.out.println("This is Inter1 show method");
    }
}
