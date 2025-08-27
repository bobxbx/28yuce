package com.ruoyi.web.controller.tool;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class ImageDownloader {
    // 基础链接地址
    private static final String BASE_URL = "http://www.gdmzgj.com/";
    // 下载文件保存的目录
    private static final String DOWNLOAD_DIR = "downloads";

    public static void main(String[] args) {
        // 图片相对链接列表
        List<String> relativeImageUrls = new ArrayList<>();
        relativeImageUrls.add("../Upload/PicFiles/20221151727552585.jpg");
        relativeImageUrls.add("../Upload/PicFiles/2022118151538924.jpg");
        relativeImageUrls.add("../Upload/PicFiles/20221181517225972.jpg");
        relativeImageUrls.add("../Upload/PicFiles/20221181518211481.jpg");
        relativeImageUrls.add("../Upload/PicFiles/2022118152043889.jpg");
        relativeImageUrls.add("../Upload/PicFiles/20221181520536086.jpg");
        relativeImageUrls.add("../Upload/PicFiles/20221181521418271.jpg");
        relativeImageUrls.add("../Upload/PicFiles/20221181522186155.jpg");
        relativeImageUrls.add("../Upload/PicFiles/2022118152349155.jpg");
        relativeImageUrls.add("../Upload/PicFiles/20221181523435861.jpg");
        relativeImageUrls.add("../Upload/PicFiles/20221181524346606.jpg");
        relativeImageUrls.add("../Upload/PicFiles/20221181525474828.jpg");
        relativeImageUrls.add("../Upload/PicFiles/20221181526254835.jpg");
        relativeImageUrls.add("../Upload/PicFiles/2022118152725321.jpg");
        relativeImageUrls.add("../Upload/PicFiles/20221181528122516.jpg");
        relativeImageUrls.add("../Upload/PicFiles/20221181528543430.jpg");
        relativeImageUrls.add("../Upload/PicFiles/20221181529285775.jpg");
        relativeImageUrls.add("../Upload/PicFiles/20221181530556081.jpg");
        relativeImageUrls.add("../Upload/PicFiles/20221181531331722.jpg");
        relativeImageUrls.add("../Upload/PicFiles/20221181532201650.jpg");
        relativeImageUrls.add("../Upload/PicFiles/20221181532572338.jpg");
        relativeImageUrls.add("../Upload/PicFiles/2022118153444205.jpg");
        relativeImageUrls.add("../Upload/PicFiles/20221181534424505.jpg");
        relativeImageUrls.add("../Upload/PicFiles/20221181536239488.jpg");
        relativeImageUrls.add("../Upload/PicFiles/20221181537104903.jpg");
        relativeImageUrls.add("../Upload/PicFiles/20221181537506058.jpg");
        relativeImageUrls.add("../Upload/PicFiles/20221181538269137.jpg");
        relativeImageUrls.add("../Upload/PicFiles/2022118153912145.jpg");
        relativeImageUrls.add("../Upload/PicFiles/20221181539372126.jpg");
        relativeImageUrls.add("../Upload/PicFiles/20221181540319450.jpg");
        relativeImageUrls.add("../Upload/PicFiles/20221181541121421.jpg");
        relativeImageUrls.add("../Upload/PicFiles/20221181541531040.jpg");
        relativeImageUrls.add("../Upload/PicFiles/20221181542262180.jpg");
        relativeImageUrls.add("../Upload/PicFiles/20221181543243859.jpg");
        relativeImageUrls.add("../Upload/PicFiles/20221181543585146.jpg");
        relativeImageUrls.add("../Upload/PicFiles/20221181544303041.jpg");
        relativeImageUrls.add("../Upload/PicFiles/2022118154523180.jpg");
        relativeImageUrls.add("../Upload/PicFiles/20221181545429824.jpg");
        relativeImageUrls.add("../Upload/PicFiles/20221181546128961.jpg");
        relativeImageUrls.add("../Upload/PicFiles/20221181546398965.jpg");
        relativeImageUrls.add("../Upload/PicFiles/20221181547139200.jpg");
        relativeImageUrls.add("../Upload/PicFiles/20221181547494611.jpg");
        relativeImageUrls.add("../Upload/PicFiles/20221181548205578.jpg");
        relativeImageUrls.add("../Upload/PicFiles/20221181548481031.jpg");
        relativeImageUrls.add("../Upload/PicFiles/20221181549204828.jpg");
        relativeImageUrls.add("../Upload/PicFiles/20221181550199751.jpg");
        relativeImageUrls.add("../Upload/PicFiles/20221181551476201.jpg");
        relativeImageUrls.add("../Upload/PicFiles/20221181552181827.jpg");
        relativeImageUrls.add("../Upload/PicFiles/2022118155367243.jpg");
        relativeImageUrls.add("../Upload/PicFiles/20221181553455154.jpg");
        relativeImageUrls.add("../Upload/PicFiles/20221181554198978.jpg");
        relativeImageUrls.add("../Upload/PicFiles/20221181554509531.jpg");
        relativeImageUrls.add("../Upload/PicFiles/20221181555227279.jpg");
        relativeImageUrls.add("../Upload/PicFiles/20221181555551529.jpg");
        relativeImageUrls.add("../Upload/PicFiles/20221181556597710.jpg");
        relativeImageUrls.add("../Upload/PicFiles/20221181557317848.jpg");
        relativeImageUrls.add("../Upload/PicFiles/2022118155874528.jpg");
        relativeImageUrls.add("../Upload/PicFiles/20221181558433534.jpg");
        relativeImageUrls.add("../Upload/PicFiles/20221181559212126.jpg");
        relativeImageUrls.add("../Upload/PicFiles/20221181559543266.jpg");
        relativeImageUrls.add("../Upload/PicFiles/2022118160263405.jpg");
        relativeImageUrls.add("../Upload/PicFiles/2022118164101160.jpg");
        relativeImageUrls.add("../Upload/PicFiles/2022118165319265.jpg");
        relativeImageUrls.add("../Upload/PicFiles/2022118169326395.jpg");
        relativeImageUrls.add("../Upload/PicFiles/2022118161551218.jpg");
        relativeImageUrls.add("../Upload/PicFiles/20221181615395749.jpg");
        relativeImageUrls.add("../Upload/PicFiles/20221181616116302.jpg");
        relativeImageUrls.add("../Upload/PicFiles/20221181616578180.jpg");
        relativeImageUrls.add("../Upload/PicFiles/20221181617328078.jpg");
        relativeImageUrls.add("../Upload/PicFiles/20221181618154773.jpg");
        relativeImageUrls.add("../Upload/PicFiles/20221181618462228.jpg");
        relativeImageUrls.add("../Upload/PicFiles/20221181620141629.jpg");
        relativeImageUrls.add("../Upload/PicFiles/2022118162182280.jpg");
        relativeImageUrls.add("../Upload/PicFiles/20221181621579952.jpg");
        relativeImageUrls.add("../Upload/PicFiles/20221181622342642.jpg");
        relativeImageUrls.add("../Upload/PicFiles/2022118162354878.jpg");
        relativeImageUrls.add("../Upload/PicFiles/20221181623346176.jpg");
        relativeImageUrls.add("../Upload/PicFiles/2022118162426676.jpg");
        relativeImageUrls.add("../Upload/PicFiles/20221181624313341.jpg");
        relativeImageUrls.add("../Upload/PicFiles/2022118162536284.jpg");
        relativeImageUrls.add("../Upload/PicFiles/20221181625345155.jpg");
        relativeImageUrls.add("../Upload/PicFiles/2022118162644560.jpg");
        relativeImageUrls.add("../Upload/PicFiles/20221181627536422.jpg");
        relativeImageUrls.add("../Upload/PicFiles/20221181629148051.jpg");
        relativeImageUrls.add("../Upload/PicFiles/20221181629522851.jpg");
        String baseUrl = "http://154.82.84.195:8000/profile/upload/2025/04/22/";

        for (String relativeUrl : relativeImageUrls) {
            String fileName = relativeUrl.substring(relativeUrl.lastIndexOf('/') + 1);
            String fullUrl = baseUrl + fileName;
            System.out.println(fullUrl);
        }
//        // 处理并下载图片
//        for (String relativeUrl : relativeImageUrls) {
//            String fullUrl = BASE_URL + relativeUrl.replace("../", "");
//            downloadImage(fullUrl);
//        }
    }

    /**
     * 下载图片的方法
     *
     * @param imageUrl 图片的完整链接
     */
    public static void downloadImage(String imageUrl) {
        // 创建下载目录
        File dir = new File(DOWNLOAD_DIR);
        if (!dir.exists()) {
            dir.mkdirs();
        }

        try (BufferedInputStream in = new BufferedInputStream(new URL(imageUrl).openStream());
             FileOutputStream fileOutputStream = new FileOutputStream(dir + File.separator + imageUrl.substring(imageUrl.lastIndexOf('/') + 1))) {
            byte[] dataBuffer = new byte[1024];
            int bytesRead;
            while ((bytesRead = in.read(dataBuffer, 0, 1024)) != -1) {
                fileOutputStream.write(dataBuffer, 0, bytesRead);
            }
            System.out.println("Successfully downloaded " + imageUrl);
        } catch (IOException e) {
            System.err.println("Failed to download " + imageUrl + ": " + e.getMessage());
        }
    }
}