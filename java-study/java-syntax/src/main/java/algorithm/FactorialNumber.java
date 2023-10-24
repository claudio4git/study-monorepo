package algorithm;

import java.util.stream.*;

/*
 * It is the multiplication of N by predecessors grater or equal to 1.
 */
public class FactorialNumber {
    public static void main(String[] args) {
        System.out.println("Factorial of 0 is: " + recursiveApproach(0));
        System.out.println("Factorial of 2 is: " + recursiveApproach(2));
        System.out.println("Factorial of 3 is: " + recursiveApproach(3));
        System.out.println("Factorial of 4 is: " + iterativeApproach(4));
        System.out.println("Factorial of 5 is: " + lambdaApproach(5));
    }

    public static long recursiveApproach(long number) {
        if (number <= 1) {
            return 1;
        } else {
            return number * recursiveApproach(number - 1);
        }
    }

    public static long iterativeApproach(long number) {
        long result = 1L;
        while (number != 0) {
            result *= number;
            number--;
        }
        return result;
    }

    public static long lambdaApproach(long number) {
        return LongStream.rangeClosed(2, number)
                .reduce(1, (long a, long b) -> a * b);
    }
}
