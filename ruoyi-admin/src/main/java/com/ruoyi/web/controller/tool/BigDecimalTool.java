package com.ruoyi.web.controller.tool;



import com.alibaba.fastjson2.JSONObject;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.util.Random;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class BigDecimalTool {
    public static String getCode(int length) {
        String characters = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
        Random random = new Random();
        StringBuilder randomString = new StringBuilder(length);

        for (int i = 0; i < length; i++) {
            int randomIndex = random.nextInt(characters.length());
            randomString.append(characters.charAt(randomIndex));
        }

        return randomString.toString();
    }

    public static String ToTow(String amount) {
        try {
            // 使用 BigDecimal 解析字符串，避免精度丢失
            BigDecimal numericAmount = new BigDecimal(amount);

            // 四舍五入到小数点后15位（保留最多15位小数）
            numericAmount = numericAmount.setScale(15, RoundingMode.HALF_UP);

            // 去除末尾多余的零
            numericAmount = numericAmount.stripTrailingZeros();

            // 转换为普通字符串（非科学计数法）
            String formatted = numericAmount.toPlainString();

            // 处理整数情况（如 "123.0000" → "123"）
            if (formatted.contains(".") && formatted.endsWith("0")) {
                formatted = formatted.replaceAll("0+$", "");  // 删除末尾所有0
                if (formatted.endsWith(".")) {
                    formatted = formatted.substring(0, formatted.length() - 1);
                }
            }

            return formatted;
        } catch (NumberFormatException e) {
            return "Invalid number format";
        }
    }

    public static boolean isMaxD(String doubleNumber, String allAmount) {

        // 将字符串 allAmount 转换为 BigDecimal
        BigDecimal bdAllAmount = new BigDecimal(allAmount);
        BigDecimal bdDoubleNumber = new BigDecimal(doubleNumber);

        // 使用 compareTo 比较大小
        // compareTo 返回 -1 表示 bdDoubleNumber 小于 bdAllAmount，0 表示相等，1 表示大于
        return bdDoubleNumber.compareTo(bdAllAmount) <= 0;    }


    public static String Subtract(String amount1 ,String amount2){


        // 使用 BigDecimal 将字符串转换为高精度的数值类型
        BigDecimal bigDecimalAmount1 = new BigDecimal(amount1);
        BigDecimal bigDecimalAmount2 = new BigDecimal(amount2);

        // 进行减法运算
        BigDecimal result = bigDecimalAmount1.subtract(bigDecimalAmount2);

        // 打印结果
        return  ToTow(result.toPlainString());
    }
    public static String Subtract(String amount1 ,String amount2,String amount3){


        // 使用 BigDecimal 将字符串转换为高精度的数值类型
        BigDecimal bigDecimalAmount1 = new BigDecimal(amount1);
        BigDecimal bigDecimalAmount2 = new BigDecimal(amount2);
        BigDecimal bigDecimalAmount3 = new BigDecimal(amount3);

        // 进行减法运算
        BigDecimal result = bigDecimalAmount1.subtract(bigDecimalAmount2);
        BigDecimal results = result.subtract(bigDecimalAmount3);

        // 打印结果
        return  ToTow(results.toString());
    }
    public static String Subtract(String amount1 ,String amount2,String amount3 ,String amount4){


        // 使用 BigDecimal 将字符串转换为高精度的数值类型
        BigDecimal bigDecimalAmount1 = new BigDecimal(amount1);
        BigDecimal bigDecimalAmount2 = new BigDecimal(amount2);
        BigDecimal bigDecimalAmount3 = new BigDecimal(amount3);
        BigDecimal bigDecimalAmount4 = new BigDecimal(amount4);

        // 进行减法运算
        BigDecimal result = bigDecimalAmount1.subtract(bigDecimalAmount2);
        BigDecimal results = result.subtract(bigDecimalAmount3);
        BigDecimal resultss = results.subtract(bigDecimalAmount4);

        // 打印结果
        return resultss.toString();
    }
    public static String Subtract(String amount1 ,String amount2,String amount3 ,String amount4,String amount5){


        // 使用 BigDecimal 将字符串转换为高精度的数值类型
        BigDecimal bigDecimalAmount1 = new BigDecimal(amount1);
        BigDecimal bigDecimalAmount2 = new BigDecimal(amount2);
        BigDecimal bigDecimalAmount3 = new BigDecimal(amount3);
        BigDecimal bigDecimalAmount4 = new BigDecimal(amount4);
        BigDecimal bigDecimalAmount5 = new BigDecimal(amount5);

        // 进行减法运算
        BigDecimal result = bigDecimalAmount1.subtract(bigDecimalAmount2);
        BigDecimal results = result.subtract(bigDecimalAmount3);
        BigDecimal resultss = results.subtract(bigDecimalAmount4);
        BigDecimal resultsss = resultss.subtract(bigDecimalAmount5);

        // 打印结果
        return resultsss.toString();
    }


    public static long MathRound(long l) {
        int number = 7;  // 示例整数

        // 执行整数除以 2 并四舍五入
        int result = Math.round((float) number / 2);
        return result;
    }

    public static boolean CheckInRange(String startStr, String endStr, String targetStr) {
        BigDecimal start = new BigDecimal(endStr);
        BigDecimal end = new BigDecimal(targetStr);
        BigDecimal target = new BigDecimal(startStr);

        boolean isRange= target.compareTo(start) >= 0 && target.compareTo(end) <= 0; // 检查目标是否在范围内
        return isRange;
    }
    public static boolean isWithinRange(String amount, String minAmount, String maxAmount) {
        // 将字符串转换为 BigDecimal
        BigDecimal amt = new BigDecimal(amount);
        BigDecimal minAmt = new BigDecimal(minAmount);
        BigDecimal maxAmt = new BigDecimal(maxAmount);

        // 使用 compareTo 进行比较
        return amt.compareTo(minAmt) >= 0 && amt.compareTo(maxAmt) <= 0;
    }
    public static String addNumberStr(String strNumber1,String strNumber2){
        try {
            if(strNumber1!=null && strNumber2!=null){
                // 将字符串转换为 BigDecimal
                BigDecimal decimalNumber1 = new BigDecimal(strNumber1);
                BigDecimal decimalNumber2 = new BigDecimal(strNumber2);

                // 执行相加操作
                BigDecimal result = decimalNumber1.add(decimalNumber2);
                String s = result.toPlainString();
                // 打印结果
                return  ToTow(s);
            }else {
                if(strNumber1!=null){
                    return ToTow(strNumber1);
                }
                if(strNumber2!=null){
                    return ToTow(strNumber2);

                }
                return "0";
            }
        }catch (Exception e){
            return "0";
        }


    }
    /**
     * 将两个字符串数字相乘
     *
     * @param num1 第一个字符串数字
     * @param num2 第二个字符串数字
     * @return 相乘的结果字符串
     * @throws IllegalArgumentException 如果输入的字符串不是有效数字
     */
    public static String multiply(String num1, String num2) {
        try {
            // 将字符串转换为 BigDecimal
            BigDecimal bd1 = new BigDecimal(num1);
            BigDecimal bd2 = new BigDecimal(num2);

            // 执行乘法
            BigDecimal result = bd1.multiply(bd2);

            // 返回结果字符串
            return ToTow(result.toPlainString());
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("输入的数字格式无效: " + e.getMessage(), e);
        }
    }


    /**
     * 判断大小
     * @param doubleNumber
     * @param allAmount
     * @return
     */
    public static boolean isMax(String doubleNumber, String allAmount) {


        // 将字符串 allAmount 转换为 BigDecimal
        BigDecimal bdAllAmount = new BigDecimal(allAmount);
        BigDecimal bdDoubleNumber = new BigDecimal(doubleNumber);

        // 使用 compareTo 比较大小
        // compareTo 返回 -1 表示 bdDoubleNumber 小于 bdAllAmount，0 表示相等，1 表示大于
        return bdDoubleNumber.compareTo(bdAllAmount) < 0;
    }


    /**
     * 执行除法并保留两位小数，传入字符串参数
     * @param dividendStr 被除数的字符串
     * @param divisorStr 除数的字符串
     * @return 结果，保留两位小数
     * @throws IllegalArgumentException 如果字符串无法转换为数字
     */
    public static String divideAndScale(String dividendStr, String divisorStr) {
        try {
            BigDecimal dividend = new BigDecimal(dividendStr);
            BigDecimal divisor = new BigDecimal(divisorStr);

            if (divisor.compareTo(BigDecimal.ZERO) == 0) {
                throw new ArithmeticException("除数不能为零");
            }

            // 执行除法并保留两位小数
            BigDecimal result = dividend.divide(divisor, 15, RoundingMode.HALF_UP);
            return result.toPlainString(); // 返回结果的字符串表示
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("无效的数字格式", e);
        }
    }
    private static final String CHARACTERS = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
    private static final int LENGTH = 10;
    public static boolean validateAmount(String amount) {
        // 校验金额格式
        // 正则表达式：允许最多两位小数
        String regex = "^[0-9]+(\\.[0-9]{1,2})?$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(amount);

        return matcher.matches();
    }
    public static String generateRandomString() {
        Random random = new Random();
        StringBuilder sb = new StringBuilder(LENGTH);

        for (int i = 0; i < LENGTH; i++) {
            int index = random.nextInt(CHARACTERS.length());
            sb.append(CHARACTERS.charAt(index));
        }

        return sb.toString();
    }


}
