/*
Задать одномерный массив. Написать методы поиска в нём минимального и максимального элемента;
* Привести функции к корректному виду и дополнительно написать ещё две функции так, чтобы получились (четыре) функции
поиска минимального и максимального как значения, так и индекса.
 */

package seminar2;

import java.util.Scanner;

public class Task1 {
    private static int findMin(int[] a) {
        int min = a[0];
        for (int i = 1; i < a.length; i++) {
            if (a[i] < min) {
                min = a[i];
            }
        }
        return min;
    }

    private static int findMax(int[] a) {
        int max = a[0];
        for (int i = 1; i < a.length; i++) {
            if (a[i] > max) {
                max = a[i];
            }
        }
        return max;
    }

    private static int findIndexMin(int[] a) {
        int min = 0;
        for (int i = 1; i < a.length; i++) {
            if (a[i] < a[min]) {
                min = i;
            }
        }
        return min;
    }

    private static int findIndexMax(int[] a) {
        int max = 0;
        for (int i = 1; i < a.length; i++) {
            if (a[i] > a[max]) {
                max = i;
            }
        }
        return max;
    }

    public static void main(String[] args) {
        int[] array0 = new int[]{2, 8, 4, 5, 1, 11, 3};
        System.out.printf("Максимальный элемент массива: %d\n", findMax(array0));
        System.out.printf("Минимальный элемент массива: %d\n", findMin(array0));
        System.out.printf("Индекс максимального элемента массива: %d\n", findIndexMax(array0));
        System.out.printf("Индекс минимального элемента массива: %d\n", findIndexMin(array0));
    }
}
