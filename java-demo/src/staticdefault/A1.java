package staticdefault;

public class A1 implements Inter1{
    @Override
    public void show1() {

    }

    static void showStatic(){
        System.out.println("This is A1 showStatic  method");
    }

    public static void main(String[] args) {
        Inter1 inter1 = new A1();
        Inter1.showStatic();
    }
}
