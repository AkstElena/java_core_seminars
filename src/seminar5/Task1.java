package seminar5;
/*
 Создать массив из 9 цифр и записать его в файл, используя поток
вывода.

Удостовериться, что числа записаны не символами, а цифрами, что сократит объём хранения в 8 и более раз
(из-за представления цифр в виде ASCII символов). При этом важно помнить о допущениях такого способа записи,
поскольку числа нужно как-то отделять друг от друга, а любой символ, например, пробел (32), имеет числовое
представление, и внутри файла будет неотличим от числа 20. А любое отрицательное число будет воспринято потоком
чтения как конец потока. Для выполнения задания сделать разделителем число 0.
 */


import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.FileVisitResult;
import java.util.Arrays;


public class Task1 {

    public static void writeToFile(int[] arr) throws IOException {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < arr.length - 1; i++) {
            stringBuilder.append(arr[i]).append("0");
        }
        stringBuilder.append(arr[arr.length - 1]);

        try (FileWriter fileWriter = new FileWriter("src/seminar5/resources/task1-2.txt")) {
            fileWriter.write(String.valueOf(stringBuilder));
        }

    }

    public static void main(String[] args) throws IOException {
        int[] array = {1, 2, 3, 4, 5, 6, 7, 8, 9};
//        try (FileWriter fileWriter = new FileWriter("src/seminar5/resources/task1.txt")){
//            fileWriter.write(Arrays.toString(array));
//        }
        writeToFile(array);


    }
}
