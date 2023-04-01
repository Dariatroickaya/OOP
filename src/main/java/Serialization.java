import java.io.*;

public class Serialization {
    static File file = new File("products");

    public static void writeProduct(Product data) {
        try (ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream(file))) {
            objectOutputStream.writeObject(data);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static Product listProduct() {
        Product productList = null;
        try (ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream(file))) {
            productList = (Product) objectInputStream.readObject();
        } catch (FileNotFoundException exception) {
            exception.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        return productList;
    }
}
