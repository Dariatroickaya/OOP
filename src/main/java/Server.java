import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Arrays;

public class Server {
    public static void main(String[] args) {
        try(ServerSocket serverSocket = new ServerSocket(1234)) {
            System.out.println("Сервер запущен!");
            Socket socket = serverSocket.accept();
            System.out.println("Клиент подключился!");
            DataOutputStream dataOutputStream = new DataOutputStream(socket.getOutputStream());
            DataInputStream dataInputStream = new DataInputStream(socket.getInputStream());

            while(true) {
                String clientRequest = dataInputStream.readUTF();

                if ("0".equals(clientRequest)) {
                    break;
                } else if ("1".equals(clientRequest)) {
                    String[] productData = dataInputStream.readUTF().trim().split(",");

                    NoteBook noteBook = new NoteBook(productData[0], productData[1], productData[2], Float.parseFloat(productData[7]),
                            productData[4], productData[5], productData[6], Integer.parseInt(productData[7].trim()), productData[8]);

                    Serialization.writeProduct(noteBook);

                    dataOutputStream.writeUTF("Новый товар успешно добавлен!");
                } else if ("2".equals(clientRequest)) {
                    Product productList = Serialization.listProduct();
                    dataOutputStream.writeUTF(String.valueOf(productList));
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}