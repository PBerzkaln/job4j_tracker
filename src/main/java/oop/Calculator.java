package oop;

public class Calculator {

    private static int x = 5;

    public int sum(int y) {
        return x + y;
    }

    public static int minus(int y) {
        return  y - x;
    }

    public int multiply(int y) {
        return y * x;
    }

    public int divide(int y) {
        return y / x;
    }

    public static void main(String[] args) {
        Calculator calculator = new Calculator();
        int rsl = calculator.sumAllOperation(10);
        System.out.println(rsl);
    }

    public int sumAllOperation(int y) {
        return sum(y) + multiply(y) + minus(y) + divide(y);
    }
}