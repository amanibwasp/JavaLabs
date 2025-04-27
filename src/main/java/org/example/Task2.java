package org.example;

import java.util.Scanner;

public class Task2 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("Введите натуральное число n: ");
        int n = in.nextInt();
        while (n <= 0) {
            System.out.println("Оно не натуральное. Попробуйте снова: ");
            n = in.nextInt();
        }
        int result = 0;
        System.out.printf("Теперь нужно ввести %d чисел для знакочередующейся суммы ряда\n", n);
        for (int i = 0; i < n; i++) {
            System.out.printf("%d из %d: ", i+1, n);
            int number = in.nextInt();
            if (i % 2 == 0) {
                result += number;
            } else {
                result -= number;
            }
        }
        System.out.println(result);
        in.close();
    }
}
