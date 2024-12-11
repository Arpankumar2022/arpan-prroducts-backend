package staticdefault;

public interface Inter1 {

    static void showStatic(){
        System.out.println("This is Inter1 showStatic  method");
    }


    default void show(){
        System.out.println("This is Inter1 show method");
    }

    public void show1();
}
