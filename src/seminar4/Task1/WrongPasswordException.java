package seminar4.Task1;

public class WrongPasswordException extends Exception {
    public WrongPasswordException(String current) {
         super(String.format("Повторный пароль %s не соотвествует первоначально введенному", current));
    }

    public WrongPasswordException(String expected, String current) {
        super(String.format("Ожидалось не менее %s символов в пароле, получили %s", expected, current));
    }
}


