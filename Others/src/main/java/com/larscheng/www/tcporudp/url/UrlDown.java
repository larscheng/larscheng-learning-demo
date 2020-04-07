package com.larscheng.www.tcporudp.url;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

public class UrlDown {
    public static void main(String[] args) throws IOException {
        URL url = new URL("https://www.larscheng.com/img/001.png");

        HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();
        InputStream inputStream = urlConnection.getInputStream();
        String path = "/home/lars/Self/larscheng-learning-demo/Others/src/main/java/com/larscheng/www/tcporudp/url/a.png";
        FileOutputStream fileOutputStream = new FileOutputStream(new File(path));
        byte[] bytes = new byte[1024];
        int len;
        while ((len = inputStream.read(bytes)) != -1) {
            fileOutputStream.write(bytes, 0, len);
        }


        fileOutputStream.close();
        inputStream.close();
    }
}
