package ru.stqa.pft.sandbox;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Collections {

    public static void main(String[] args) {
        //массив
        String[] langs = {"Java", "C#", "Python", "PHP"};
        for (String l : langs) {
            System.out.println("Я хочу выучить " + l);
        }

        //список
        List<String> language = Arrays.asList("Java", "C#", "Python", "PHP");
        for (String l : language) {
            System.out.println("Я хочу выучить " + l);
        }
        //список объектов произольного типа
        List lang1 = Arrays.asList("Java", "C#", "Python", 1, 2.0);
        for (Object l : lang1) {
            System.out.println("Я хочу выучить " + l);
        }
    }
}
