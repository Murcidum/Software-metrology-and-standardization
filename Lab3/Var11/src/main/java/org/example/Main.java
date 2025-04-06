package org.example;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Ввод первой матрицы
        int[] dimensions1 = inputMatrixDimensions(scanner, "A");
        int[][] matrixA = createMatrix(scanner, dimensions1[0], dimensions1[1]);

        // Ввод второй матрицы
        int[] dimensions2 = inputMatrixDimensions(scanner, "B");
        int[][] matrixB = createMatrix(scanner, dimensions2[0], dimensions2[1]);

        // Вычисление сумм главных диагоналей
        int sumA = calculateDiagonalSum(matrixA);
        int sumB = calculateDiagonalSum(matrixB);

        // Выбор матрицы с минимальной суммой
        int[][] selectedMatrix = selectMatrixWithMinDiagonalSum(matrixA, sumA, matrixB, sumB);

        // Вывод результата
        System.out.println("Матрица с меньшей суммой элементов на главной диагонали:");
        printMatrix(selectedMatrix);

        scanner.close();
    }

    // Функция для ввода размеров матрицы
    public static int[] inputMatrixDimensions(Scanner scanner, String matrixName) {
        System.out.println("Введите количество строк и столбцов для матрицы " + matrixName + ":");
        int rows = scanner.nextInt();
        int cols = scanner.nextInt();
        return new int[]{rows, cols};
    }

    // Функция для создания и заполнения матрицы
    public static int[][] createMatrix(Scanner scanner, int rows, int cols) {
        int[][] matrix = new int[rows][cols];
        System.out.println("Введите элементы матрицы построчно:");
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                matrix[i][j] = scanner.nextInt();
            }
        }
        return matrix;
    }

    // Функция для вычисления суммы элементов на главной диагонали
    public static int calculateDiagonalSum(int[][] matrix) {
        int rows = matrix.length;
        int cols = matrix[0].length;
        int minDim = Math.min(rows, cols);
        int sum = 0;
        for (int i = 0; i < minDim; i++) {
            sum += matrix[i][i];
        }
        return sum;
    }

    // Функция для выбора матрицы с меньшей суммой
    public static int[][] selectMatrixWithMinDiagonalSum(int[][] matrix1, int sum1, int[][] matrix2, int sum2) {
        return (sum1 < sum2) ? matrix1 : matrix2;
    }

    // Функция для вывода матрицы
    public static void printMatrix(int[][] matrix) {
        for (int[] row : matrix) {
            for (int element : row) {
                System.out.print(element + "\t");
            }
            System.out.println();
        }
    }
}