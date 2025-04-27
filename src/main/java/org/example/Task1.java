package org.example;


import java.util.Scanner;

public class Task1 {
    static int calculateSteps(int n) {
        int steps = 0;
        while (n != 1) {
            if (n % 2 == 0) {
                n /= 2;
            } else {
                n = 3 * n + 1;
            }
            steps++;
        }
        return steps;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("Введите натуральное число n: ");
        int num = in.nextInt();
        while (num <= 0) {
            System.out.println("Оно не натуральное. Попробуйте снова: ");
            num = in.nextInt();
        }
        System.out.printf("Количество шагов, необходимое стартующей\n" +
                "от %d сиракузской последовательности, чтобы впервые дойти до 1: %d", num, calculateSteps(num));
        in.close();
    }
}