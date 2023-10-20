package main.recursion;

public class Recursion {
    public static void main(String[] args) {
        int result = sum(10);
        System.out.println(result);
    }

    /*
     *  10 + sum(9)
     *  10 + ( 9 + sum(8) )
     *  10 + ( 9 + ( 8 + sum(7) ) )
     *  ...
     *  10 + 9 + 8 + 7 + 6 + 5 + 4 + 3 + 2 + 1 + 0
     */
    public static int sum(int value) {
        if (value > 0) {
            return value + sum(value - 1);
        } else {
            return 0;
        }
    }
}
