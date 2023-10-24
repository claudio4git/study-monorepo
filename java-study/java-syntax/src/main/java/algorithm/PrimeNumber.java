package algorithm;

import java.util.stream.*;

/*
 * A prime number is a whole number greater than 1 whose only factors are 1 and itself.
 * The only even prime number is 2.
 */
public class PrimeNumber {

    public static void main(String[] args) {
        PrimeNumber primeNumber = new PrimeNumber();
        System.out.println("Is 23 prime number: " + primeNumber.isPrimeV1(23));
        System.out.println("Is 17 prime number: " + primeNumber.isPrimeV2(17));
        System.out.println("Is 23 prime number: " + primeNumber.isPrimeV3(23));
    }

    public boolean isPrimeV1(long number) {
        for (int i = 2; i < number; i++) {
            if (number % i == 0) {
                return false;
            }
        }
        return true;
    }

    public boolean isPrimeV2(long number) {
        if (number % 2 == 0) return false; // if n is a multiple of 2 is false
        for (int i = 3; (long) i * i <= number; i += 2) {
            if (number % i == 0) {
                return false;
            }
        }
        return true;
    }

    public boolean isPrimeV3(long number) {
        if (number % 2 == 0) return false;
        return number > 1 && IntStream
                .rangeClosed(2, (int) Math.sqrt(number))
                .noneMatch(divisor -> number % divisor == 0);
    }
}
