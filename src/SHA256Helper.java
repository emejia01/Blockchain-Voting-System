/*
Class used to find the hash of a given input.
Will be used by Block Objects in the Blockchain
*/

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class SHA256Helper {

    // Method to return SHA Hash of a string input
    public static String getHash(String input) throws NoSuchAlgorithmException {

        // Get hash in Byte form
        MessageDigest md = MessageDigest.getInstance("SHA-256");
        byte[] hash = md.digest(input.getBytes(StandardCharsets.UTF_8));

        // Convert Hash to String
        StringBuilder sb = new StringBuilder();
        for (byte b : hash) {
            sb.append(String.format("%02X", b));
        }
        return sb.toString();
    }
}
