package ru.shishkin.javaLessonFromComputer12.lesson1;

import java.util.Scanner;

public class ApplicationL1 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int t1 = scan.nextInt();
        int t2 = t1 % 60;
        System.out.println(t2);
        if ((t2 == 1) || (t2 == 2) || (t2 == 4) || (t2 == 7)) {
            System.out.println("no");
        }
        if ((t2 != 1) || (t2 != 2) || (t2 != 4) || (t2 != 7)) {
            System.out.println("yes");
        }
    }
}
	
