package seminar2;

import java.math.BigDecimal;
import java.util.Scanner;

public class Task0 {
    public static void main(String[] args) {
        BigDecimal a = BigDecimal.valueOf(99999999);


        Scanner scanner = new Scanner(System.in);
        BigDecimal b = scanner.nextBigDecimal();


        System.out.println(b.multiply(a));
    }
}
