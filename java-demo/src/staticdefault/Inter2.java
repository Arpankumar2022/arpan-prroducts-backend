package staticdefault;

public interface Inter2 {
    static void showStatic(){
        System.out.println("This is Inter2 showStatic  method");
    }


    default void show(){
        System.out.println("This is Inter2 show method");
    }
}
