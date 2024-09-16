package functionalinterface.function;

import java.util.function.BiFunction;
import java.util.function.Function;

public class _Function {

    public static void main(String[] args) {
        System.out.println(increment(0));

        Function<Integer, Integer> incrementByOneFunction = number -> number + 1;
        System.out.println(incrementByOneFunction.apply(0));

        DealWithNumber<Integer,Integer> sum = x -> x + 2;
        System.out.println(sum.apply(3));

        DealWithNumber<Double,Double> multiply = x -> x * 2;
        System.out.println(multiply.apply(2.5));

        Function<String,String> ToUpperMethod = s -> s.toUpperCase();
        System.out.println(ToUpperMethod.apply("Hello"));

        Function<Double,String> multiplyAndConcatenate = number -> {
                number = number * 2;
                return "This is your number * 2 = " + number;
        };
        System.out.println(multiplyAndConcatenate.apply(8.0));

        // Define a DealWithNumber to add 2
        DealWithNumber<Integer, Integer> addTwo = x -> x + 2;
        System.out.println(addTwo.apply(3));

        // Define a DealWithNumber to multiply by 2
        DealWithNumber<Integer, Integer> multiplyByTwo = x -> x * 2;
        System.out.println(multiplyByTwo.apply(2));

        // Compose functions: first add 2, then multiply by 2
        DealWithNumber<Integer, Integer> addThenMultiply = addTwo.andThen(multiplyByTwo).andThen(x -> x + 1);
        System.out.println(addThenMultiply.apply(3));

        BiFunction<Integer, Integer, String> sum2numberAndPrint = (num1, num2) -> {
            int num = num1 + num2;

         
            return "This is num1 + num2 = " + num;
        };

        System.out.println(sum2numberAndPrint.apply(3, 2));

        Function<Integer, Integer> multiplyBy100 = number -> number * 100;
        System.out.println(incrementByOneFunction.andThen(multiplyBy100).apply(5));
   }


    public static int increment (int number) {
        return ++number;
    }
}
