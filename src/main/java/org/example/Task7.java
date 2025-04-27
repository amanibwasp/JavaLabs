package org.example;


import java.util.Arrays;

public class Task7 {
    public static void main(String[] args) {
        int[][] matrix = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        };
        System.out.println("Максимумы строк: " + Arrays.toString(findRowMaxima(matrix)));
    }

    public static int[] findRowMaxima(int[][] matrix) {
        int[] maxNumInARow = new int[matrix.length];
        for (int i = 0; i < matrix.length; i++) {
            int max = matrix[i][0];
            for (int j = 1; j < matrix[i].length; j++) {
                if (matrix[i][j] > max) {
                    max = matrix[i][j];
                }
            }
            maxNumInARow[i] = max;
        }
        return maxNumInARow;
    }
}