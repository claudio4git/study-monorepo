public class Fibonacci {

    public static void main(String[] args) {
        var fibonacci = new Fibonacci();

        var recursive = fibonacci.getPositionRecursive(5);
        System.out.println("Fibonacci recursive: " + recursive);

        System.out.print("Fibonacci trace recursive: ");
        for (int i = 0; i <= 5; i++) {
            System.out.print(fibonacci.getPositionRecursive(i) + ",");
        }

        var iterative = fibonacci.getPositionIterative(5);
        System.out.println("Fibonacci iterative and trace: " + iterative);
    }

    public int getPositionRecursive(int value) {
        if (value <= 1) {
            return value;
        }
        return getPositionRecursive(value - 1) + getPositionRecursive(value - 2);
    }

    public int getPositionIterative(int value) {
        if (value <= 1) {
            return value;
        }

        System.out.println();
        System.out.print("0,1");

        // 0,1,1,2,3,4...
        int prev = 0, next = 1; // 0, 1 starts
        for (int i = 2; i <= value; i++) {
            int sum = prev + next;
            prev = next;
            next = sum;

            System.out.print("," + next);
        }

        System.out.println();

        return next;
    }
}
