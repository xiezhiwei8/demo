package com.xzw.utils;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * @Author: 谢志伟
 * @Description:
 * @Data: Created in 2018/9/21 15:46
 * @ModifiedBy:
 */
public class HttpRequestUtil {
    /*日志*/
    private static Logger log = LogManager.getLogger(HttpRequestUtil.class);

    /**
     * @Author: XieZhiWei
     * @Description:向指定URL发送GET方法的请求
     * @param:[url]
     * @return:java.lang.String
     * @CreateData:2018/9/21 15:50
     **/
    public static String sendGet(String url) {
        String resData = null;
        try {
            URL realUrl = new URL(url);
            HttpURLConnection httpConn = (HttpURLConnection) realUrl.openConnection();
            httpConn.setRequestMethod("GET");
            httpConn.connect();
            BufferedReader reader = new BufferedReader(new InputStreamReader(httpConn.getInputStream()));
            String line;
            StringBuffer buffer = new StringBuffer();
            while ((line = reader.readLine()) != null) {
                buffer.append(line);
            }
            reader.close();
            httpConn.disconnect();
            resData = buffer.toString();
        } catch (Exception e) {
            resData = new String("{\"errcode\":\"1001\",\"errMsg\":\"远程服务未开启\"}");
            e.printStackTrace();
            log.error("远程服务未开启", e);
        }
        return resData;
    }
}
