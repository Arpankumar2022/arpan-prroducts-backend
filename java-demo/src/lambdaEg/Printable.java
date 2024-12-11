package lambdaEg;

@FunctionalInterface
public interface Printable<T> {

    public void print(T str);
}
