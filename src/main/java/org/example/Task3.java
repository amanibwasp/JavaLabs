package org.example;

import java.util.Scanner;

public class Task3 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите координаты клада X и Y: ");

        int treasureX = scanner.nextInt();
        int treasureY = scanner.nextInt();

        int currentX = 0;
        int currentY = 0;

        int stepCount = 0;

        String direction;
        int distance;

        while (!(direction = scanner.next()).equalsIgnoreCase("стоп")) {
            distance = scanner.nextInt();

            switch (direction.toLowerCase()) {
                case "север":
                    currentY += distance;
                    break;
                case "юг":
                    currentY -= distance;
                    break;
                case "восток":
                    currentX += distance;
                    break;
                case "запад":
                    currentX -= distance;
                    break;
            }

            stepCount++;

            if (currentX == treasureX && currentY == treasureY) {
                break;
            }
        }

        System.out.println(stepCount);

        scanner.close();
    }
}