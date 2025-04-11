package seminar5;

/*
Написать программу заменяющую указанный символ в текстовом
файле на пробел, сохраняющую получившийся текст в новый файл.
 */


import java.io.*;
import java.util.Arrays;

public class Task3 {

    public static String makeString(String path) throws IOException {
        try (BufferedInputStream stream = new BufferedInputStream(new FileInputStream(path))) {
            return new String(stream.readAllBytes());
        }
    }


    public static void writeFile(String path, String newPath, char oldSymbol, char newSymbol) throws IOException {
        String string = makeString(path);
        string = string.replaceAll(String.valueOf(oldSymbol), String.valueOf(newSymbol));
        try (FileWriter writer = new FileWriter(newPath)) {
            writer.write(string);
        }


    }

    public static void main(String[] args) throws IOException {
        writeFile("src/seminar5/resources/text3.txt", "src/seminar5/resources/newText3.txt",
                'T', ' ');

    }
}
