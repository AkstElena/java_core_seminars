package seminar5;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.FileVisitResult;
import java.nio.file.Files;
import java.sql.Array;
import java.util.ArrayList;
import java.util.Arrays;

/*
Создать массив целых чисел и заполнить его информацией из
файла, записанного в предыдущем задании.
Прочитать данные из файла с числами, предполагая, что разделитель – это число 0
 */
public class Task2 {

    public static int[] readFile(String path) throws IOException {
        ArrayList<Integer> arrayList = new ArrayList<>();
        try (FileReader fileReader = new FileReader(path)) {
            int n;
            while ((n = fileReader.read()) != -1) {
                char temp = (char) n;
                if (temp != '0') {
                    try {
                        arrayList.add(Integer.parseInt(String.valueOf(temp)));
                    } catch (NumberFormatException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
        int[] result = new int[arrayList.size()];
        int index = 0;
        for (Integer integer : arrayList) {
            result[index] = integer;
            index++;
        }
        return result;
    }

    public static int[] readFileDevZero(String path) throws IOException {
        ArrayList<Integer> arrayList = new ArrayList<>();
        try (FileReader fileReader = new FileReader(path)) {
            int n;
            boolean flag = false;
            while ((n = fileReader.read()) != -1) {
                char temp = (char) n;
                if (temp == '0' && flag) {
                    flag = false;
                }
                else {
                    flag = true;
                    try {
                        arrayList.add(Integer.parseInt(String.valueOf(temp)));
                    } catch (NumberFormatException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
        int[] result = new int[arrayList.size()];
        int index = 0;
        for (Integer integer : arrayList) {
            result[index] = integer;
            index++;
        }
        return result;
    }

    public static void main(String[] args) throws IOException {

        System.out.println(Arrays.toString(readFile("src/seminar5/resources/task1-2.txt")));
        System.out.println(Arrays.toString(readFileDevZero("src/seminar5/resources/task1-2.txt")));

    }
}
