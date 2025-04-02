/*
Создать квадратный целочисленный массив (количество строк и столбцов одинаковое),
заполнить его диагональные элементы единицами, используя цикл(ы)
 */

package seminar2;

import java.sql.Array;
import java.util.Arrays;

public class Task2 {


    public static void main(String[] args) {
        int a = 5;
        int[][] myarray = new int[a][a];
        for (int i = 0; i < a; i++) {
            for (int j = 0; j < a; j++) {
                if ((i == j) || (i + j == a - 1)) {
                    myarray[i][j] = 1;
                }
            }
        }
        for (int i = 0; i < myarray.length; i++) {
            System.out.println(Arrays.toString(myarray[i]));
        }
    }
}
