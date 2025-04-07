package seminar4;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.function.BiFunction;

public class Main {
    public static void main(String[] args) {
//        Cat cat1 = new Cat(OldMale.MALE);
//        Cat cat2 = new Cat(OldMale.FEMALE);
//        Cat cat3 = new Cat(OldMale.MALE);
//        Cat cat4 = new Cat("Banana");
//        Cat cat5 = new Cat(OldMale.MALE);

        Cat cat1 = new Cat(Male.MALE);
        Cat cat2 = new Cat(Male.FEMALE);
        Cat cat3 = new Cat(Male.MALE);
        Cat cat4 = new Cat(Male.FEMALE);
        Cat cat5 = new Cat(Male.MALE);

        Cat[] cats = {cat1, cat2, cat3, cat4, cat5};
        List<Cat> catList = Arrays.asList(cats);  // традиционный лист


        for (Cat cat : cats) {
            switch (cat.getMale()) {
                case MALE -> System.out.println("Кот - мальчик");
                case FEMALE -> System.out.println("Кот - девочка");
            }
        }

        // через итератор
        Iterator<Cat> iterator = catList.iterator();
        while (iterator.hasNext()) {
            Cat cat = iterator.next();
            switch (cat.getMale()) {
                case MALE -> System.out.println("Кот - мальчик");
                case FEMALE -> System.out.println("Кот - девочка");
            }
        }


        System.out.println("***");
        for (Cat cat: catList) {
            System.out.println(cat.getMale().getRussianMaleTitle());
        }
        System.out.println("***");

        // создание анонимного класса
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                System.out.println("Run!");
            }
        };


//        // через лямбда выражение то же самое, что выше
//        Runnable runnable2 = () -> {
//                System.out.println("New Run!");
//        };

        // но так как одна строка можно убрать фигурные скобки и свести все к одной строке
        Runnable runnable2 = () -> System.out.println("New Run!");


        runnable.run(); // новый экземепляр с реализованным методом, без создания где-то отдельно
        runnable2.run();


        //
        /*
        в данной конструкции передается функциональность с двумя аргументами (первыми int) и на выходе результат (string)
        То есть создается новый экземпляр по интерфейсу beFunctional с реализацией одного метода этого интерфейса (apply)
         */
        BiFunction<Integer, Integer, String> biFunction = new BiFunction<Integer, Integer, String>() {
            @Override
            public String apply(Integer a, Integer b) {
                return String.format("%s + %s = %s", a, b, a + b);
            }
        };

        BiFunction<Integer, Integer, String> biFunction2 =
                (a, b) -> String.format("NEW RESULT: %s + %s = %s", a, b, a + b);


        System.out.println(biFunction.apply(8, 3));
        System.out.println(biFunction2.apply(15, 3));


    }
}
