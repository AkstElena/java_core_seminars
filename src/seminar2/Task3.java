/*
Написать метод, в который передается не пустой одномерный целочисленный массив,
метод должен вернуть true если в массиве есть место, в котором сумма левой и правой части массива равны.
Примеры:
checkBalance([1, 1, 1, || 2, 1]) → true,
checkBalance([2, 1, 1, 2, 1]) → false,
checkBalance([10, || 1, 2, 3, 4]) → true.
Абстрактная граница показана символами ||, эти символы в массив не входят
 */

package seminar2;

import java.util.Arrays;

public class Task3 {

    private static boolean checkBalance(int[] a) {
        int left = 0;
        for (int i = 0; i < a.length - 1; i++) {
            left += a[i];
            int right = 0;
            for (int j = i + 1; j < a.length; j++) {
                right += a[j];
            }
            if (left == right) return true;
        }
        return false;
    }


    public static void main(String[] args) {
        int[] myarray1 = {2, 8, 4, 5, 1, 11, 3};
        int[] myarray2 = {10, 1, 2, 3, 4};
        System.out.println(checkBalance(myarray1));
        System.out.println(checkBalance(myarray2));

    }
}
