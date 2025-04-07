package seminar4.Task1;

public class WrongLoginException extends Exception{
    public WrongLoginException() {
//        this("Неверный формат логина", "Больше 20 символов");
    }

    public WrongLoginException(String expected, String current) {
        super(String.format("Ожидалось не более %s символов в логине, получили %s", expected, current));
    }
}
