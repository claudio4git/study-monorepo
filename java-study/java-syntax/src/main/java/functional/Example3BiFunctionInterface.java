package functional;

import java.util.function.BiFunction;

public class Example3BiFunctionInterface {
    public static void main(String[] args) {
        BiFunction<Integer, Integer, Integer> add =
                (x, y) -> x + y;

        BiFunction<Integer, Integer, Integer> add2 =
                Integer::sum;

        System.out.println(add.apply(3, 2)); // print 5
        System.out.println(add2.apply(3, 2)); // print 5
    }
}
