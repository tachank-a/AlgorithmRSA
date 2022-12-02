import algorithm.RSA;
import utils.*;

import java.math.BigInteger;
import java.util.List;


public class Main {
    public static void main(String[] args) {
        RSA rsa = new RSA("ru");
        String message = FileManager.readFromInput();

        System.out.println("Message: " + message);

        List<BigInteger> encryptedBytes = rsa.encrypt(message.getBytes());

        byte[] decryptedBytes = rsa.decrypt(encryptedBytes);

        String result = new String(decryptedBytes);

        FileManager.writeToFile(result);
    }
}