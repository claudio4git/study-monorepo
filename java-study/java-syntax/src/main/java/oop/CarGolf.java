package oop;

public class CarGolf extends CarAbstract implements Car {

    public CarGolf() {
        System.out.println("Car golf constructor");
    }

    @Override
    public String getColor() {
        return "Blue";
    }

    @Override
    public String run() {
        return "Running";
    }

    public String getBrand() {
        return "Golf";
    }
}
