package java8;

import java.util.function.*;

public class LambdaExmaple {

    public static void main(String[] args) {

        Predicate<Integer> predObj = (a)-> a>10?true:false;
      //  System.out.println(predObj.test(10));

        BiFunction<Integer, Integer, String>  biFunction = (a,b)-> new String(a+" "+b);
      //  System.out.println(biFunction.apply(2,3));

        Consumer<String>  consumer = (s)->System.out.println(new String(s+"Arpan"));
       // consumer.accept("Hello");

        BiPredicate<String, String> biPredicate = (a,b)-> a.equals(b)?true:false;
     //   System.out.println( biPredicate.test("arpan", "babu"));
      //  System.out.println( biPredicate.test("arpan", "arpan"));
        Supplier<Integer>  supplier = ()-> Integer.valueOf(10);
        Supplier<Double>  supplierSecond = ()-> Math.random();
       // System.out.println(supplier.get());
       // System.out.println(supplierSecond.get());



        Function<Integer, String>  function = (a)-> a+"  Arpan";
       // System.out.println(function.apply(10));

        UnaryOperator<Integer> unaryOperator = (a)->  a+10;
      //  System.out.println(unaryOperator.apply(10));

        BinaryOperator<Integer>  binaryOperator = (a,b)-> a*b;
        System.out.println(binaryOperator.apply(10,20));

   }
}
