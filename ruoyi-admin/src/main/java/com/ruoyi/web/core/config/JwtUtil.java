package com.ruoyi.web.core.config;


import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.Claim;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.github.pagehelper.util.StringUtil;


import java.text.SimpleDateFormat;
import java.util.*;

/**
 * @Author WZY
 * token 生成器
 */
public class JwtUtil {
    //过期时间
    private static final String TIME = "2021-09-01";
    //私钥
    private static String TOKEN_SECRET = "tailettqs";




    /**
     * 生成签名
     *  WZY
     * @param **username**
     * @param **password**
     * @return
     */
    public static String newToken(String userid) {
        try {
            // 设置过期时间为当前时间加30分钟
            Calendar calendar = Calendar.getInstance(TimeZone.getTimeZone("UTC"));
            calendar.add(Calendar.MINUTE, 30000); // 当前时间加30分钟
            Date expirationDate = calendar.getTime(); // 获取过期时间

            // 私钥和加密算法
            Algorithm algorithm = Algorithm.HMAC256(TOKEN_SECRET);

            // 设置头部信息
            Map<String, Object> header = new HashMap<>(2);
            header.put("Type", "Jwt");
            header.put("alg", "HS256");

            // 生成并返回 JWT token
            return JWT.create()
                    .withHeader(header)
                    .withClaim("userid", userid) // 自定义 claim
                    .withExpiresAt(expirationDate) // 设置过期时间
                    .sign(algorithm); // 使用 HMAC256 算法生成签名
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public static Boolean isToken(String token) {
        try {
            // 解析 Token

           if(!StringUtil.isEmpty(token)){
               DecodedJWT decodedJWT = JWT.decode(token);

               // 获取 Token 中的过期时间（exp）
               Date expirationDate = decodedJWT.getExpiresAt();
               Date currentDate = new Date();
               String s = timeStamp2Date(String.valueOf(currentDate.getTime()/1000), null);
               String s1 = timeStamp2Date(String.valueOf(expirationDate.getTime()/1000), null);

//            // 打印详细的时间信息，帮助调试
//            System.out.println("Expiration Date: " + expirationDate.toString());
//            System.out.println("Current Date: " + currentDate.toString());
//            System.out.println("Expiration Date (milliseconds): " + expirationDate.getTime());
//            System.out.println("Current Date (milliseconds): " + currentDate.getTime());


               // 判断 Token 是否过期
               return !expirationDate.before(currentDate); // 如果过期时间小于当前时间，则表示已过期
           }else {
               return false;
           }
        } catch (Exception e) {
            e.printStackTrace();
            return false; // 如果解析 Token 出错，认为 Token 过期
        }


    }



    /**
     * 时间戳转换成日期格式字符串
     *
     * @param seconds 精确到秒的字符串
     * @param format
     * @return
     */
    public static String timeStamp2Date(String seconds, String format) {
        TimeZone tz = TimeZone.getTimeZone("ETC/GMT-8");
        TimeZone.setDefault(tz);

        if (seconds == null || seconds.isEmpty() || seconds.equals("null")) {
            return "";
        }
        if (format == null || format.isEmpty()) {
            format = "yyyy-MM-dd HH:mm:ss";
        }

        SimpleDateFormat sdf = new SimpleDateFormat(format);
        sdf.setTimeZone(TimeZone.getTimeZone("Asia/Shanghai"));
        String format1 = sdf.format(new Date(Long.valueOf(seconds + "000")));

        return format1;
    }
    public static String fafaf(){
        return "sadasdasdadasd";
    }
    public static String getTokenUserid(String refreshToken) {
        try {
            if(refreshToken!=null){
                Algorithm algorithm = Algorithm.HMAC256(TOKEN_SECRET);
                JWTVerifier verifier = JWT.require(algorithm).build();
                DecodedJWT jwt = verifier.verify(refreshToken);
                Map<String, Claim> claims = jwt.getClaims();
                Claim userid = claims.get("userid");
                return userid.asString();
            }else {
                return null;
            }
        }catch (Exception e){
            return null;
        }


    }
public static void main(String[] adrr) {
    String da = newToken("da");
    System.out.println(da);
    String tokenUserid = getTokenUserid(da);
    System.out.println(tokenUserid);
//        isToken("eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJpYXQiOjE2NDg1MzI2OTYsIm5iZiI6MTY0ODUzMjY5NiwiZGF0YSI6eyJleHBpcmVkVGltZSI6MTY0ODYxOTA5NiwicmVmcmVzaFRva2VuIjoiZXlKMGVYQWlPaUpLVjFRaUxDSmhiR2NpT2lKSVV6STFOaUo5LmV5SmxlSEJwY21Wa1ZHbHRaU0k2TVRZME9EVXpNamMxTml3aWRYVnBaQ0k2SWpObFlXWXdZMkpqTFRWbVltTXROREV3TUMxaU5HWmlMVEJqTVdNM1lUWTJNelk1WVNKOS50U09qTUxVa1phRG1sb3Y2WDNHTnoxWXd2bmdGUXBmWkM5X3k5em5mbm5RIn19.j-R4QuUxwSi7ndhOEvHoRAjbl31UL3y_1AB6RDUTkJA");



}

}