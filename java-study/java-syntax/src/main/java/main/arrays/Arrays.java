package main.arrays;

public class Arrays {
    public static void main(String[] args) {
        // main.arrays
        String[] names;
        String[] colors = { "blue", "yellow" };

        System.out.println(colors.length);
        System.out.println(colors[0]);

        // multidimensional
        int[][] numbers = { {1,3}, {4,5} };
        System.out.println(numbers[0][0]);
    }
}
