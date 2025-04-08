package Task2;


import java.util.Arrays;

/*
1. Написать классы покупатель (ФИО, возраст, телефон), товар (название, цена) и заказ (объект покупатель, объект товар,
целочисленное количество).
2. Создать массив покупателей (инициализировать 2 элемента), массив товаров (инициализировать 5 элементов) и
массив заказов (пустой на 5 элементов).
3. Создать статический метод «совершить покупку» со строковыми параметрами, соответствующими полям объекта заказа.
Метод должен вернуть объект заказа.
4. Если в метод передан несуществующий покупатель – метод должен выбросить исключение CustomerException,
если передан несуществующий товар, метод должен выбросить исключение ProductException, если было передано отрицательное
или слишком больше значение количества (например, 100), метод должен выбросить исключение AmountException.
5. Вызвать метод совершения покупки несколько раз таким образом, чтобы заполнить массив покупок возвращаемыми
значениями. Обработать исключения следующим образом (в заданном порядке):
– если был передан неверный товар – вывести в консоль сообщение об ошибке, не совершать данную покупку;
– если было передано неверное количество – купить товар в количестве 1;
– если был передан неверный пользователь – завершить работу приложения с исключением.
6. Вывести в консоль итоговое количество совершённых покупок после выполнения основного кода приложения.
 */

public class Main {

    private final static Customer[] customers = {
            new Customer("Elena", 31, "89012225554"),
            new Customer("Renat", 27, "89178899551"),
    };

    private final static Product[] products = {
            new Product("milk", 140),
            new Product("banana", 160),
            new Product("bread", 55),
            new Product("juice", 185),
            new Product("meat", 540),
    };

    private static Order[] orders = new Order[5];

    private static boolean isInArray(Object[] arr, Object o) {
        for (int i = 0; i < arr.length; i++)
            if (arr[i].equals(o)) return true;
        return false;
    }

    public static Order makeOrder(Customer customer, Product product, Integer quantity)
            throws AmountException, CustomerException, ProductException {
        if (!isInArray(customers, customer)) {
            throw new CustomerException("Данного покупателя нет в списке");
        }
        if (!isInArray(products, product)) {
            throw new ProductException("Данного продукта нет в списке");
        }
        if (quantity > 100 || quantity < 0) {
            throw new AmountException("Количество продукции не может быть орицательно или более 100 штук");
        }
        Order order = new Order(customer, product, quantity);
        return order;


    }

    public static void main(String[] args) throws CustomerException, AmountException, ProductException {

        System.out.println("Покупатели: " + Arrays.toString(customers));
        System.out.println("Товары: " + Arrays.toString(products));

        Object[][] info = {
                {customers[0], products[0], 1}, //good
                {customers[1], products[1], -1}, //bad amount -1
                {customers[0], products[2], 150}, //bad amount >100
                {customers[1], new Product("Flower", 500), 1}, //no item
                {new Customer("Alex", 40, "89235146233"), products[3], 1}, //no customer
        };
        System.out.println("Сп");
        for (Object[] order : info
        ) {
            System.out.println(Arrays.toString(order));
        }

        int capacity = 0;
        int i = 0;
        while (capacity != orders.length - 1 || i != info.length) {
            try {
                orders[capacity] = makeOrder((Customer) info[i][0], (Product) info[i][1], (int) info[i][2]);
                capacity++;
            } catch (ProductException e) {
                e.printStackTrace();
            } catch (AmountException e) {
                orders[capacity++] = makeOrder((Customer) info[i][0], (Product) info[i][1], 1);
            } catch (CustomerException e) {
                throw new RuntimeException(e);
            } finally {
                System.out.println("Orders made: " + capacity);
            }
            ++i;
        }

    }
}
