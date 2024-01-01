package functional;

import java.util.function.Function;

public class Example2FunctionInterfaceWithLambda {
    public static void main(String[] args) {
        Function<Integer, Integer> absoluteValue =
                (x) -> x < 0 ? -x : x;

        System.out.println(absoluteValue.apply(-100)); // print 100
        System.out.println(absoluteValue.apply(98)); // print 98
    }
}
