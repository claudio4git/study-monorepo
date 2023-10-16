package br.com.jccf;

import java.util.function.BiFunction;

public class Example3BiFunctionInterface {
    public static void main(String[] args) {
        BiFunction<Integer, Integer, Integer> add =
                (x, y) -> x + y;

        System.out.println(add.apply(3, 2)); // print 5
    }
}
