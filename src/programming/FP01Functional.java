package programming;

import org.jetbrains.annotations.NotNull;

import java.util.List;

public class FP01Functional {
    public static void main(String[] args) {

        List<Integer> numbers = List.of(12, 9, 13, 4, 6, 2, 4, 12, 15);
        printAllNumbersInListFuncitonal(numbers);
        printEvenNumbersInListFuncitonal(numbers);
        printSquaresOfEventNumbersInListFuncitonal(numbers);
    }

    //Print all numbers
    private static void printAllNumbersInListFuncitonal(@NotNull List<Integer> numbers) {
       //What to do?
       numbers.stream()
               .forEach(System.out::println);//Method reference
    }

    private static boolean isEven(int number){
        return number%2==0;
    }

    //Number -> number%2 ==0
    private static void printEvenNumbersInListFuncitonal(@NotNull List<Integer> numbers) {
        //What to do?
        numbers.stream()
                //.filter(FP01Functional::isEven) //Only allow even numbers
                .filter(number -> number%2 ==0) //lambda Expression
                .forEach(System.out::println);//Method reference
    }

    //Print square of numbers
    private static void printSquaresOfEventNumbersInListFuncitonal(@NotNull List<Integer> numbers) {
        //What to do?
        numbers.stream()
                .filter(number -> number%2 ==0) //lambda Expression
                .map(number -> number*number)
                .forEach(System.out::println);//Method reference
    }
}
