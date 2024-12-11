package staticdefault;

public class A6 extends  A1{

     static void showStatic(){
        System.out.println("This is A6 showStatic  method");
    }

    public static void main(String[] args) {
        A1 a1=new A6();
        a1.showStatic();
    }
}
