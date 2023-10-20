package oop;

public class Program {
    public static void main(String[] args) {
        // here we have just the run method
        Car golf = new CarGolf();
        System.out.println(golf.run());

        // here we have the showBrand method
        CarGolf golf1 = new CarGolf();
        golf1.run();
        System.out.println(golf1.getBrand());
    }
}
