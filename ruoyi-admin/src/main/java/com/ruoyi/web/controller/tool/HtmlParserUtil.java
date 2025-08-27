package com.ruoyi.web.controller.tool;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class HtmlParserUtil {
    // 1. 读取 HTML 内容（支持远程 URL 或本地文件）
    public static String getHtmlContent(String source) throws Exception {
        // 新增：source 非空校验，提前抛出自定义异常，便于排查
        if (source == null || source.trim().isEmpty()) {
            throw new IllegalArgumentException("HTML 源地址（source）不能为空！请检查 LotteryController 中的 HTML_SOURCE 配置");
        }

        Document doc;
        if (source.trim().startsWith("http")) { // 加 trim() 避免空格导致判断失效
            // 处理远程 URL
            doc = Jsoup.connect(source)
                    .userAgent("Mozilla/5.0 (Windows NT 10.0; Win64; x64) Chrome/112.0.0.0 Safari/537.36")
                    .timeout(10000) // 超时时间 10 秒，避免卡死
                    .ignoreContentType(true) // 忽略内容类型，防止 HTML 被识别为其他类型
                    .get();
        } else {
            // 处理本地文件：先判断文件是否存在
            File htmlFile = new File(source);
            if (!htmlFile.exists()) {
                throw new FileNotFoundException("本地 HTML 文件不存在！路径：" + source);
            }
            doc = Jsoup.parse(htmlFile, "UTF-8"); // 明确编码为 UTF-8，避免乱码
        }
        return doc.html();
    }
    // 2. 从 HTML 中提取 appData 的 JSON 字符串
    public static String extractAppDataJson(String html) {
        // 正则表达式：匹配 "var appData = " 到 ";" 之间的内容
        String regex = "var appData = (\\{[\\s\\S]*?\\});";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(html);

        if (matcher.find()) {
            String json = matcher.group(1);
            // 处理 JavaScript 语法转 JSON 语法（如单引号→双引号，去除末尾逗号）
            json = json.replaceAll("'", "\"")
                    .replaceAll(",\\s*\\}", "}")
                    .replaceAll(",\\s*\\]", "]");
            return json;
        }
        throw new RuntimeException("HTML 中未找到 appData 数据");
    }
}
