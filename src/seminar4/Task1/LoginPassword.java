package seminar4.Task1;

public class LoginPassword {

    private String login;
    private String password;
    private String confirmPassword;

    public static boolean checkLoginPass(String login, String password, String confirmPassword) {
        try {
            if (login.length() >= 20) {
                throw new WrongLoginException(String.format("20"), String.valueOf(login.length()));
            }
            if (password.length() < 20) {
                throw new WrongPasswordException(String.format("20"), String.valueOf(password.length()));
            }
            if (!password.equals(confirmPassword)) {
                throw new WrongPasswordException(confirmPassword);
            }
        } catch (WrongLoginException | WrongPasswordException e) {
            e.printStackTrace(); // вывести текст ошибки
            return false;
        }
        return true;
    }
}
