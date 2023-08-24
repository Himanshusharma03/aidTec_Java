
import java.util.Random;
public class PasswordGenerator {

private static final String CHAR_SET = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789!@#$%^&*()";

  public static String generatePassword(int length) {

    StringBuilder password = new StringBuilder();
    Random random = new Random();

    for (int i = 0; i < length; i++) {
      int index = random.nextInt(CHAR_SET.length());

      password.append(CHAR_SET.charAt(index));
    }
    return password.toString();
  }

  public static void main(String[] args) {
    System.out.print("Enter the length of the password: ");
    int length = Integer.parseInt(System.console().readLine());

    String password = generatePassword(length);
    System.out.println("Your password is: " + password);
  }
}
