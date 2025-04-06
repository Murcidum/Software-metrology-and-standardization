package org.example;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Ввод размеров матрицы
        System.out.print("Введите количество строк m: ");
        int m = scanner.nextInt();
        System.out.print("Введите количество столбцов n: ");
        int n = scanner.nextInt();

        // Проверка корректности размеров
        if (m <= 0 || n <= 0) {
            System.out.println("Размеры матрицы должны быть положительными числами!");
            return;
        }

        // Создание и заполнение матрицы
        int[][] matrix = new int[m][n];
        System.out.println("Введите элементы матрицы:");
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                matrix[i][j] = scanner.nextInt();
            }
        }

        // Поиск минимального положительного элемента
        int minPositive = Integer.MAX_VALUE;
        int minRow = -1;
        int minCol = -1;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int current = matrix[i][j];
                if (current > 0 && current < minPositive) {
                    minPositive = current;
                    minRow = i;
                    minCol = j;
                }
            }
        }

        // Вывод результата
        if (minRow != -1) {
            System.out.println("Минимальный положительный элемент: " + minPositive);
            System.out.println("Индексы: [" + minRow + "][" + minCol + "]");
        } else {
            System.out.println("В матрице нет положительных элементов.");
        }
    }
}