package algorithm;


import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

public class RSA {
    String type;
    BigInteger p = new BigInteger("307");
    BigInteger q = new BigInteger("151");
    BigInteger e = new BigInteger("11");
    BigInteger d;

    BigInteger z;
    BigInteger n;


    public RSA(String type) {
        z = p.subtract(BigInteger.ONE).multiply(q.subtract(BigInteger.ONE));
        n = p.multiply(q);
        d = e.modInverse(z);
        this.type = type;
    }


    public List<BigInteger> encrypt(byte... messageBytes) {
        List<BigInteger> encryptedMessageLetters = new ArrayList<>();

        for (byte b :
                messageBytes) {
            if (type.equals("ru")) {
                b *= -1;
            }
            encryptedMessageLetters.add(new BigInteger(String.valueOf(b)).modPow(e, n));
        }
        System.out.println("\n\n");
        return encryptedMessageLetters;
    }

    public byte[] decrypt(List<BigInteger> encryptedMessageLetters) {
        List<BigInteger> decryptedBytes = new ArrayList<>();

        for (BigInteger b :
                encryptedMessageLetters) {
            decryptedBytes.add(b.modPow(d, n));
        }

        byte[] bytes = new byte[decryptedBytes.size()];

        for (int i = 0; i < decryptedBytes.size(); i++) {
            bytes[i] = decryptedBytes.get(i).byteValue();
            if (type.equals("ru")) {
                bytes[i] *= -1;
            }
        }
        return bytes;
    }
}