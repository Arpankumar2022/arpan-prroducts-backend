package staticdefault;

public class A7 implements Inter1,Inter2{


    public static void main(String[] args) {
        A7 a7 = new A7();
        a7.show();

    }

    @Override
    public void show() {
      System.out.println(10);
    }

    @Override
    public void show1() {

    }
}
