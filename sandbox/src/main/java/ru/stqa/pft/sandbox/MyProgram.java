package ru.stqa.pft.sandbox;

public class MyProgram {
    public static void main(String[] args) {
        hello("user");
        hello("world");

        Square s = new Square(5);
        System.out.println("Площадь квадрата со стороной "+s.l+" = " +s.area());

        Rectangle r = new Rectangle(4, 6);
        System.out.println("Площадь треугольника со сторонами "+ r.a + " и "+ r.b+" = "+r.area());
    }

    public static void hello(String somebody){
        System.out.println("Hello world");
    }





}
