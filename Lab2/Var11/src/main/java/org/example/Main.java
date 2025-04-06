package org.example;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int C = scanner.nextInt();
        int D = scanner.nextInt();

        int start = Math.max(C, 100000);
        int end = Math.min(D, 999999);

        boolean found = false;

        for (int num = start; num <= end; num++) {
            int highPart = num / 1000;
            int lowPart = num % 1000;

            if (sumOfDigits(highPart) == sumOfDigits(lowPart)) {
                System.out.println(num);
                found = true;
            }
        }

        if (!found) {
            System.out.println("Необходимых чисел нет");
        }
    }

    private static int sumOfDigits(int num) {
        int sum = 0;
        while (num != 0) {
            sum += num % 10;
            num /= 10;
        }
        return sum;
    }
}