package main.statements;

public class Statements {
    public static void main(String[] args) {

        // if/else if/else
        if (args == null) {
            System.out.println("Args is null");
            return;
        } else if (args.length == 1) {
            System.out.println("Args is 1");
        } else {
            System.out.println("Args is different from null and 1");
        }

        // switch
        switch (args.length) {
            case 1:
                System.out.println("Args is 1");
                break;
            case 2:
                System.out.println("Args is 2");
                break;
            default:
                System.out.println("Default value");
        }

        // while
        byte whileValue = 1;
        while (whileValue <= 10) {
            System.out.println("Args is " + whileValue);
            whileValue++;
        }

        // do/while
        byte doWhileValue = 1;
        do {
            System.out.println("Value is 1");
            doWhileValue++;
        } while (doWhileValue >= 10);

        // for
        for (byte i = 0; i < 10; i++) {
            System.out.println("i value is " + i);
        }

        // forEach
        String[] names = {"John", "Maria"};
        for (String name : names) {
            System.out.println("Name is " + name);
        }
    }
}
