/*
Написать метод, осуществляющий сортировку одномерного
массива подсчётом. Важное ограничение состоит в том, что для этой
сортировки диапазон значений исходного массива должен находиться в
разумных пределах, например, не более 1000.
 */

package seminar2;

import java.util.Arrays;
import java.util.TreeMap;

public class Task5 {

    private static int[] counSort(int[] array) {
        int tmpArr[] = new int[array.length];

        TreeMap<Integer, Integer> map = new TreeMap<>();
        for (int i = 0; i < array.length; i++) {
            map.put(array[i], map.getOrDefault(array[i], 0) + 1);
//            if (map.containsKey(array[i])) {
//                map.put(array[i], map.get(array[i]) + 1);
//            } else {
//                map.put(array[i], 1);
//            }
        }
        System.out.println(map.toString());
        int i = 0;
        for (Integer key : map.keySet()) {
            for (int j = 0; j < map.get(key); j++) {
                tmpArr[i++] = key;
            }
        }
        return tmpArr;
    }


    public static void main(String[] args) {
        int[] myarray = {2, 1, 0, 4, 3, 0, 0, 1, 2};
        int[] newArray0 = counSort(myarray);
        System.out.println(Arrays.toString(newArray0));

    }
}
