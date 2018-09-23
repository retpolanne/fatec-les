package utils;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import javax.xml.bind.DatatypeConverter;

public class Security {
    private MessageDigest md;
    public String hashPassword (String password) {
        try {
            this.md = MessageDigest.getInstance(System.getenv("HASHING"));
            md.update(password.getBytes());
            byte[] digest = md.digest();
            return DatatypeConverter.printHexBinary(digest).toUpperCase();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
    }
}