package org.example;

import java.util.Scanner;

public class Task4 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int roadCount = scanner.nextInt();
        int bestRoad = 0;
        int maxHeight = 0;

        for (int i = 0; i < roadCount; i++) {
            int tunnelCount = scanner.nextInt();
            int minTunnelHeight = Integer.MAX_VALUE;

            for (int j = 0; j < tunnelCount; j++) {
                int height = scanner.nextInt();
                if (height < minTunnelHeight) {
                    minTunnelHeight = height;
                }
            }

            if (minTunnelHeight > maxHeight) {
                maxHeight = minTunnelHeight;
                bestRoad = i + 1;
            }
        }

        System.out.println(bestRoad + " " + maxHeight);
    }
}

