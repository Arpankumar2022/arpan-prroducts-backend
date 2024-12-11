package staticdefault;

public class A5 implements Inter1{
    @Override
    public void show1() {

    }



    public static void main(String[] args) {
        Inter1 inter1= new A5();
        inter1.show();
    }
}
