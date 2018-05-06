package com.joseph.common;

import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpPut;
import org.apache.http.client.methods.HttpDelete;

import java.net.URL;
import java.io.IOException;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URLConnection;
import java.util.Map;

public class HttpUtil {

    public static String sendGet(String url, Map<String, String> request) {
        BufferedReader in = null;
        String result = "";

        try {
            URL getUrl = new URL(url);
            URLConnection connection = getUrl.openConnection();
            connection.connect();

            in = new BufferedReader(new InputStreamReader(connection.getInputStream()));

            String line;
            while ((line = in.readLine()) != null) {
                result += line;
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if(in != null) {
                    in.close();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return result;
    }

    public static String sendPost(URL url, Map<String, String> request) {
        return "";
    }

    public static String sendPut(URL url, Map<String, String> request) {
        return "";
    }

    public static String sendDelete(URL url, Map<String, String> request) {
        return "";
    }

}
