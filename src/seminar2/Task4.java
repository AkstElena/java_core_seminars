/*
Написать функцию добавления элемента в конец массива таким образом, чтобы
она расширяла массив при необходимости.
Здесь нет смысла показывать не лучшее, но самое популярное решение, поэтому
можно продемонстрировать сразу вариант решения «со звёздочкой».
∗1 Функция должна возвращать ссылку на вновь созданный внутри себя массив, а
не использовать глобальный
 */

package seminar2;

import java.util.Arrays;

public class Task4 {

    private static int[] arrayEndAddElement(int[] array, int num) {
        int tmpArr[] = new int[array.length + 1];
        for (int i = 0; i < array.length; i++) {
            tmpArr[i] = array[i];
        }
        tmpArr[array.length] = num;
        return tmpArr;
    }


    // использование копирования массива
    private static int[] arrayEndAddElementCopyOf(int[] array, int num) {
        int[] tmpArr = Arrays.copyOf(array, array.length + 1);
        tmpArr[array.length] = num;
        return tmpArr;
    }

    private static int[] arrayIndexAddElement(int[] array, int num, int index) {
        int tmpArr[] = new int[array.length + 1];
        for (int i = 0; i < array.length; i++) {
            if (i < index) {
                tmpArr[i] = array[i];
            } else if (i == index) {
                tmpArr[i] = num;
                tmpArr[i + 1] = array[i];
            } else {
                tmpArr[i + 1] = array[i];
            }
        }
        return tmpArr;
    }

    // вариант преподавателя
    public static int[] insertIntoArray(int[] arr, int value, int index) {
        if (index < 0 || index > arr.length) {
            throw new IllegalArgumentException("Индекс вышел за рамки массива");
        }
        int[] result = new int[arr.length + 1];

        System.arraycopy(arr, 0, result, 0, index); // копируется первая половина элементов в новый массив
        result[index] = value; // разрыв, то есть новый элемент по индексу
        System.arraycopy(arr, index, result, index+1, arr.length-index); // вторая половина массива, после индекса
        return result;
    }


    // перегруженный верхний метод, где добавляется просто в конец
    public static int[] insertIntoArray(int[] arr, int value) {
        return insertIntoArray(arr, value, arr.length);
    }


    public static void main(String[] args) {
        int[] myarray = {2, 8, 4, 5, 1, 11, 3};
        int num = 99;
        int index = 3;
        int[] newArray0 = arrayEndAddElement(myarray, num);
        int[] newArray1 = arrayIndexAddElement(myarray, num, index);
        System.out.println(Arrays.toString(newArray0));
        System.out.println(Arrays.toString(newArray1));
        int[] newArray2 = arrayEndAddElementCopyOf(myarray, num);
        System.out.println(Arrays.toString(newArray2));
        int[] newArray3 = insertIntoArray(myarray, 55, 4);
        System.out.println(Arrays.toString(newArray3));
    }
}
