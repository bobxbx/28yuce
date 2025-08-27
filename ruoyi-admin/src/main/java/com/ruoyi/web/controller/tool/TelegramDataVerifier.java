package com.ruoyi.web.controller.tool;
import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import java.nio.charset.StandardCharsets;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.*;

public class TelegramDataVerifier {

    public static boolean verifyTelegramData(Map<String, String> telegramData, String botToken) {
        // 移除 hash 参数
        String receivedHash = telegramData.remove("hash");

        // 对参数进行排序
        List<String> sortedKeys = new ArrayList<>(telegramData.keySet());
        Collections.sort(sortedKeys);

        // 拼接参数
        StringBuilder dataCheckString = new StringBuilder();
        for (String key : sortedKeys) {
            if (dataCheckString.length() > 0) {
                dataCheckString.append("\n");
            }
            dataCheckString.append(key).append("=").append(telegramData.get(key));
        }

        try {
            // 生成密钥
            Mac hmac = Mac.getInstance("HmacSHA256");
            byte[] secretKey = sha256(botToken.getBytes(StandardCharsets.UTF_8));
            SecretKeySpec secretKeySpec = new SecretKeySpec(secretKey, "HmacSHA256");
            hmac.init(secretKeySpec);

            // 计算哈希值
            byte[] calculatedHashBytes = hmac.doFinal(dataCheckString.toString().getBytes(StandardCharsets.UTF_8));
            String calculatedHash = bytesToHex(calculatedHashBytes);

            // 比较哈希值
            return calculatedHash.equals(receivedHash);
        } catch (NoSuchAlgorithmException | InvalidKeyException e) {
            e.printStackTrace();
            return false;
        }
    }

    private static byte[] sha256(byte[] input) {
        try {
            java.security.MessageDigest digest = java.security.MessageDigest.getInstance("SHA-256");
            return digest.digest(input);
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }
    }

    private static String bytesToHex(byte[] bytes) {
        StringBuilder result = new StringBuilder();
        for (byte b : bytes) {
            result.append(String.format("%02x", b));
        }
        return result.toString();
    }


}