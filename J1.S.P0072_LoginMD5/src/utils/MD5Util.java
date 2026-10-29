package utils;

import java.math.BigInteger;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;

public final class MD5Util {

    private MD5Util() {
    }

    // Mã hoá chuỗi đầu vào (password) bằng thuật toán MD5, trả về chuỗi hex 32 ký tự
    public static String encrypt(String input) throws Exception {
        MessageDigest md = MessageDigest.getInstance("MD5");
        byte[] digest = md.digest(input.getBytes(StandardCharsets.UTF_8));
        BigInteger no = new BigInteger(1, digest);
        StringBuilder hashText = new StringBuilder(no.toString(16));
        while (hashText.length() < 32) {
            hashText.insert(0, "0");
        }
        return hashText.toString();
    }
}
