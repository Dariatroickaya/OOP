import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class Client {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String request;

        try (Socket socket = new Socket("localhost", 1234)) {
            DataOutputStream dataOutputStream = new DataOutputStream(socket.getOutputStream());
            DataInputStream dataInputStream = new DataInputStream(socket.getInputStream());

            while (true) {
                System.out.println("Выберите действие:\n 1. Добавить новый товар. \n 2. Вывести все товары. " +
                        "\n 0. Выйти из приложения.");
                request = scanner.nextLine();
                dataOutputStream.writeUTF(request);

                if ("0".equals(request)) {
                    break;
                } else if ("1".equals(request)) {
                    System.out.println("Введите данные через запятую: идентификационный номер, наименование, описание, " +
                            "стоимость, модель, разрешение экрана, процессор, оперативная память, видеокарта");

                    request = scanner.nextLine();
                    dataOutputStream.writeUTF(request);

                    System.out.println(dataInputStream.readUTF());
                } else if ("2".equals(request)) {
                    System.out.println(dataInputStream.readUTF());
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
