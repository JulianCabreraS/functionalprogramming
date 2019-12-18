package programming;

import java.util.List;
import java.util.function.*;

public class FP03FunctionalInterfaces2 {
    @SuppressWarnings("unused")
    public static void main(String[] args) {
        List<Integer> numbers = List.of(12,9,13,4,2,4,12,15);

        //This is result of extractions - This is boolean
        Predicate<Integer> isEvenPredicate = x -> x % 2 == 0;

        //This is result of extractions - Pass a value, obtain a value
        Function<Integer, Integer> squareFunction = x -> x * x;

        Function<Integer, String> stringFunction = x -> x+"";

        //****************Consumer
        Consumer<Integer> sysoutConsumer = System.out::println;

        BinaryOperator<Integer> sumBinaryOperator = (x,y) -> x+y;

        //****************SUPPLIER No input return something
        Supplier<Integer> randomIntegerSupplier = ()->2;
        System.out.println(randomIntegerSupplier.get());

        //****************UNARY OPERATOR
        UnaryOperator<Integer> unaryOperator = (x) -> 3*x;
        System.out.println(unaryOperator.apply(10));

        //****************BIPREDICATE
        BiPredicate<Integer, String> biPredicate = (number, str) -> {
            return  number <10 && str.length() > 5;
        };
        System.out.println(biPredicate.test(5,"in28minutes1"));

        //****************BIFUNCTION
        BiFunction<Integer, String, String> biFunction =(number, str)-> {
          return number+""+ str;
        };
        System.out.println(biFunction.apply(15,"in28minutes"));

        //****************BICONSUMER
        BiConsumer<Integer, String> biConsume = (s1,s2) -> {
            System.out.println(s1);
            System.out.println(s2);
        };



        numbers.stream()
                .filter(isEvenPredicate)
                .map(squareFunction)
                .forEach(sysoutConsumer);
    }


}
