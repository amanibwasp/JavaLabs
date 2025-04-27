package org.example;

import java.util.Arrays;
import java.util.Optional;

public class Task8 {
    public static void main(String[] args) {
        int[][] matrix = {
                {1, 2, 3, 0},//  <--------
                {4, 5, 6, -5},//          | // поворот на 90 градусов против часовой
                {7, 8, 9, 1}//   ---------
        };
        try {
            int[][] rotated = rotate90Clockwise(matrix);
            System.out.println("Повернутая матрица:");
            for (int[] row : rotated) {
                System.out.println(Arrays.toString(row));
            }
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    public static int[][] rotate90Clockwise(int[][] matrix) throws Exception {
        int n = matrix.length;
        // Чтобы найти число столбцов в исходной, если матрица не квадратная
        Optional<int[]> firstRow = Arrays.stream(matrix).findFirst();
        if (firstRow.isPresent()) {
            int m = firstRow.get().length;
            int[][] rotated = new int[m][n];

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    rotated[m - j - 1][i] = matrix[i][j];
                }
            }
            return rotated;
        }
        throw new Exception("Пустая или неверно заполненная матрица");
    }
}
