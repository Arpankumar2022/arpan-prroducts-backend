package mistakes;

public class ConsumerImplementationInteger implements Consumer<Integer>{
    @Override
    public void consume(Integer parameter) {
        System.out.println("parameter of Integer "+parameter);
    }
}
