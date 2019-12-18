package programming;

import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class FP03FunctionalInterfaces {
    @SuppressWarnings("unused")
    public static void main(String[] args) {
        List<Integer> numbers = List.of(12,9,13,4,2,4,12,15);

        //This is result of extractions - This is boolean
        Predicate<Integer> isEvenPredicate = x -> x % 2 == 0;

        Predicate<Integer> isEvenPredicate2 = new Predicate<Integer>() {
            @Override
            public boolean test(Integer x) {
                return x%2==0;
            }
        };

        //This is result of extractions - Pass a value, obtain a value
        Function<Integer, Integer> squareFunction = x -> x * x;

        Function<Integer, Integer> squareFunction2 = new Function<Integer, Integer>() {
            @Override
            public Integer apply(Integer x) {
                return x*x;
            }
        };

        //This is result of extractions
        Consumer<Integer> sysoutConsumer = System.out::println;

        Consumer<Integer> sysoutConsumer2 = new Consumer<Integer>() {
            @Override
            public void accept(Integer x) {
                System.out.println(x);
            }
        };

        numbers.stream()
                .filter(isEvenPredicate)
                .map(squareFunction)
                .forEach(sysoutConsumer);
    }


}
