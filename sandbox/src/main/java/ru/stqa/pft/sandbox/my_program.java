package ru.stqa.pft.sandbox;

public class my_program {
    public static void main(String[] args) {
        hello("user");
        hello("world");

        double l=5;
        System.out.println("Площадь квадрата со стороной "+l+" = " +area(l));

        double a=4;
        double b=6;
        System.out.println("Площадь треугольника со сторонами "+ a + " и "+ b+" = "+area(a,b));
    }

    public static void hello(String somebody){
        System.out.println("Hello world");
    }

    public static double area(double i){
        return i*i;
    }

    public static double area (double a, double b){
       return a*b;
    }

}
