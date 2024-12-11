package lambdaEg;

import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.function.Predicate;

public class UseOfPrintable {

    public static void main(String[] args) {

        BiFunction<Integer, Integer,Integer> biFunc = (n, m)-> n*m;
        System.out.println(biFunc.apply(5,10));

        Printable<String>  print = (val)-> System.out.println(val);
        print.print("Hello Arpan");

        Printable<Integer>  printInt = (val)-> System.out.println(val);
        printInt.print(20);


    }



}
