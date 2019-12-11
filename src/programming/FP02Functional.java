package programming;

import org.jetbrains.annotations.NotNull;

import java.util.List;
import java.util.stream.Collectors;

public class FP02Functional {
    public static void main(String[] args) {

        List<Integer> numbers = List.of(12, 9, 13, 4, 6, 2, 4, 12, 15);
        int sum = addListFunctional (numbers);
        System.out.println(sum);

        List<Integer> doubleNumbers = doubleList(numbers);
        System.out.println(doubleNumbers);

    }

    private static List<Integer> doubleList(List<Integer> numbers) {
        return numbers.stream()
                .map(number -> number *number)
                .collect(Collectors.toList());
    }

    private static int sum(int a,int b){
        System.out.println(a+" "+b);
        return a+b;
    }

    private static int addListFunctional(List<Integer> numbers) {

        return  numbers.stream()
                //.reduce(0,FP02Functional::sum);//Combine them into one result into one value
                //.reduce(0,(x,y)->x+y);
                .reduce(0,Integer::sum);
    }


}
