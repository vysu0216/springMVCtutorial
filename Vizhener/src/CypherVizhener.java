import java.util.Scanner;

public class CypherVizhener {

    public static void main(String[] args) {

        Scanner messageIn = new Scanner(System.in);
        Scanner keyIn = new Scanner(System.in);
        String message = "";


        System.out.println("Выбирете действие ( зашифровать - \"1\", расшифровать - \"2\" ): ");
        String operation = messageIn.nextLine();
        if (operation.equals("1")) {
            System.out.println("Введите сообщение для кодирования: ");
            message = messageIn.nextLine();

        } else if (operation.equals("2")) {
            System.out.println("Введите сообщение для декодирования: ");
            message = messageIn.nextLine();
        }

        System.out.println("Введите ключ: ");
        String key = keyIn.next();

        new Operate(message, key).fillAllMatrixes(operation);
    }

}
