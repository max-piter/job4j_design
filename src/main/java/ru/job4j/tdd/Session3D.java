package ru.job4j.tdd;

import java.util.Calendar;
import java.util.Scanner;

public class Session3D implements Session {
    public static void main(String[] args) {
        Scanner scanner =  new Scanner(System.in);
        int a = 0;
        while (true) {
           int number = scanner.nextInt();
            if (number == 0) {
                break;
            }
            a += number;

            if (a >= 1000) {
                a -= 1000;
                break;
            }

        }
        System.out.println();
        System.out.println(a);



    }
}
