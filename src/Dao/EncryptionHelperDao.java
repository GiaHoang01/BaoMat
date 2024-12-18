/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Dao;

import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.NoSuchAlgorithmException;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.util.Base64;
import javax.crypto.Cipher;

/**
 *
 * @author HUU KHANH
 */
public class EncryptionHelperDao {

    private static final int SHIFT = 3; // Số bước dịch chuyển
    private static final int DIGIT_SHIFT = 5; // Dịch chuyển riêng cho số

    public static String encrypt(String input, PublicKey publicKey) {
        StringBuilder encrypted = new StringBuilder();
        for (char c : input.toCharArray()) {
            if (Character.isDigit(c)) {
                // Mã hóa số (vòng lặp trong phạm vi '0' đến '9')
                char newChar = (char) ('0' + (c - '0' + DIGIT_SHIFT) % 10);
                encrypted.append(newChar);
            } else {
                // Mã hóa ký tự khác (giữ nguyên logic SHIFT)
                encrypted.append((char) (c + SHIFT));
            }
        }
        return encrypted.toString();
    }

    public static String decrypt(String input) {
        StringBuilder decrypted = new StringBuilder();
        for (char c : input.toCharArray()) {
            if (Character.isDigit(c)) {
                // Giải mã số (vòng lặp trong phạm vi '0' đến '9')
                char newChar = (char) ('0' + (c - '0' - DIGIT_SHIFT + 10) % 10);
                decrypted.append(newChar);
            } else {
                // Giải mã ký tự khác (giữ nguyên logic SHIFT)
                decrypted.append((char) (c - SHIFT));
            }
        }
        return decrypted.toString();
    }
    // Mã hóa RSA

    public static String encryptRSA(String data, PublicKey publicKey) throws Exception {
        Cipher cipher = Cipher.getInstance("RSA");
        cipher.init(Cipher.ENCRYPT_MODE, publicKey);
        byte[] encryptedBytes = cipher.doFinal(data.getBytes()); // Mã hóa dữ liệu thành byte[]
        return Base64.getEncoder().encodeToString(encryptedBytes); // Chuyển đổi byte[] sang Base64
    }

    public static String decryptRSA(String encryptedData, PrivateKey privateKey) throws Exception {
        Cipher cipher = Cipher.getInstance("RSA");
        cipher.init(Cipher.DECRYPT_MODE, privateKey);
        byte[] encryptedBytes = Base64.getDecoder().decode(encryptedData); // Chuyển Base64 về byte[]
        byte[] decryptedBytes = cipher.doFinal(encryptedBytes); // Giải mã byte[]
        return new String(decryptedBytes); // Chuyển byte[] thành String
    }

    // Hàm tạo cặp khóa RSA
    public static KeyPair generateRSAKeyPair() throws NoSuchAlgorithmException {
        KeyPairGenerator keyPairGenerator = KeyPairGenerator.getInstance("RSA");
        keyPairGenerator.initialize(2048); // Kích thước khóa (2048-bit)
        return keyPairGenerator.generateKeyPair();
    }
}
