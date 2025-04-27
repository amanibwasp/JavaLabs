package org.example;

import java.util.Scanner;

public class Task5 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Введите трехзначное число: ");
        int number = scanner.nextInt();
        
        if (number < 100 || number > 999) {
            System.out.println("Ошибка: число должно быть трехзначным.");
            return;
        }
        
        int digit1 = number / 100;
        int digit2 = (number / 10) % 10;
        int digit3 = number % 10;
        
        int sum = digit1 + digit2 + digit3;
        int product = digit1 * digit2 * digit3;
        
        boolean isSumEven = sum % 2 == 0;
        boolean isProductEven = product % 2 == 0;
        
        if (isSumEven && isProductEven) {
            System.out.println("Число является дважды четным.");
        } else {
            System.out.println("Число не является дважды четным.");
        }
    }
}