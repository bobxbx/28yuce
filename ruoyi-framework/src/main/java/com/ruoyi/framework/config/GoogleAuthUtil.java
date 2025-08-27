package com.ruoyi.framework.config;

import com.warrenstrange.googleauth.GoogleAuthenticator;
import com.warrenstrange.googleauth.GoogleAuthenticatorConfig;

public class GoogleAuthUtil {

    // 创建 GoogleAuthenticator 实例
    private static final GoogleAuthenticator gAuth;

    static {
        // 自定义配置
        GoogleAuthenticatorConfig config = new GoogleAuthenticatorConfig.GoogleAuthenticatorConfigBuilder()
                .setWindowSize(20) // 允许偏移 3 个时间周期（90 秒）
                .build();
        gAuth = new GoogleAuthenticator(config);
    }

    /**
     * 生成一个新的密钥
     */
    public static String generateSecretKey() {
        return gAuth.createCredentials().getKey();
    }

    /**
     * 验证用户输入的验证码是否有效
     *
     * @param secret 用户对应的密钥
     * @param code   用户输入的验证码
     * @return 验证结果，true 表示有效，false 表示无效
     */
    public static boolean verifyCode(String secret, int code) {
        return gAuth.authorize(secret, code);
    }

    public static void main(String[] args) {
//         测试生成密钥和验证验证码
        String secret = generateSecretKey();
        System.out.println("Generated Secret Key: " + secret);

//         使用密钥生成验证码
        int generatedCode = gAuth.getTotpPassword(secret);
        System.out.println("Generated Code: " + generatedCode);
//
//        // 验证用户输入的验证码
        boolean isValid = verifyCode(secret, generatedCode);
        System.out.println("Is code valid? " + isValid);
    }
}

