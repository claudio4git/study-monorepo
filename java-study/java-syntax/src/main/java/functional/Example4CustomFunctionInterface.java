package functional;

import functional.interfaces.*;

public class Example4CustomFunctionInterface {
    public static void main(String[] args) {
        TriFunction<Integer, Integer, Integer, Integer> addThree =
                (x, y, z) -> x + y + z;
        NoArgFunction<String> sayHello = () -> "Hello!";

        System.out.println(addThree.apply(3, 2, 5)); // print 10
        System.out.println(sayHello.apply()); // print Hello!
    }
}
