package mistakes;

public class ConsumerImplementationString implements  Consumer<String>{
    @Override
    public void consume(String parameter) {
        System.out.println("parameter of String "+parameter);
    }
}
