package com.sindcreate.mylibrary.comm;
import android.util.Log;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;

import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSession;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;

/**
 * Created by dabaofh on 2018/2/27.
 */

public class HttpUrls {
    public static String mtoken;
    public static String ssid;

    public static StringBuffer post(String urlString, String param) {
        Log.e("dbHttpUrls",urlString);
        if(param!=null)
        Log.e("dbHttpUrls",param);

        StringBuffer sb = new StringBuffer();
        URL url = null;
        HttpURLConnection connection = null;
        DataOutputStream out = null;
        BufferedReader in = null;
        try {
            url = new URL(urlString);





            //关键代码
            //ignore https certificate validation |忽略 https 证书验证
            if (url.getProtocol().toUpperCase().equals("HTTPS")) {
                Log.e("SmartHttpUrls","connect");
                trustAllHosts();
                HttpsURLConnection https = (HttpsURLConnection) url
                        .openConnection();
                https.setHostnameVerifier( new HostnameVerifier() {
                    @Override
                    public boolean verify(String s, SSLSession sslSession) {
                        return true;//通过所有主机名称
                    }
                });
                connection = https;
            } else {
                connection = (HttpURLConnection) url.openConnection();
            }

            if (ssid != null) {
                connection.setRequestProperty("Cookie", ssid);
           }


            connection.setReadTimeout(10000);
            connection.setDoInput(true);
            connection.setDoOutput(true);
            connection.setRequestMethod("POST");
            connection.setUseCaches(false);
            connection.setInstanceFollowRedirects(true);
            connection.setRequestProperty("Content-Type",
                    "application/json");
//            connection.setRequestProperty("User-agent","SmartApp");
//            connection.setRequestProperty("Referer", "https://app.psmartcloud.com/");
//            if(mtoken!=null){
//           connection.setRequestProperty("xtoke",mtoken);}
            connection.connect();


//            if (urlString.equals(Urls.BASE_URL+Urls.UsrLogin)) {
//                //set cookie
//                String cookieVal = connection.getHeaderField("Set-Cookie");
//                if (cookieVal != null) {
//                    String[] cookieArray = cookieVal.split(";");
//                    cookieVal = cookieArray[0];
//                    if (cookieVal != null) {
//                        ssid=cookieVal;
//
//                    }
//                }
//            }

if(param!=null) {
    out = new DataOutputStream(
            connection.getOutputStream());
    //out.writeBytes(param);
    out.write(param.getBytes());
    out.flush();
}
            in = new BufferedReader(new InputStreamReader(
                    connection.getInputStream()), 512);
            String line;
            while ((line = in.readLine()) != null) {
                sb.append(line.trim());
            }
       //     Log.e("db_testpost",sb.toString());
        } catch (IOException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            if (out != null) {
                try {
                    out.close();
                } catch (IOException e) {
                }
            }
            if (in != null) {
                try {
                    in.close();
                } catch (IOException e) {
                }
            }
            if (connection != null) {
                connection.disconnect();
            }
            Log.e("db_testpost","POST请求完毕数据为");
            Log.e("db_testpost",sb.toString());
            return sb;
        }

    }

    public static void trustAllHosts() {
        // Create a trust manager that does not validate certificate chains
        // Android use X509 cert
        TrustManager[] trustAllCerts = new TrustManager[] { new X509TrustManager() {
            public X509Certificate[] getAcceptedIssuers() {
                return new X509Certificate[] {};
            }

            public void checkClientTrusted(X509Certificate[] chain,
                                           String authType) throws CertificateException {
            }

            public void checkServerTrusted(X509Certificate[] chain,
                                           String authType) throws CertificateException {
            }
        } };

        // Install the all-trusting trust manager
        try {
            SSLContext sc = SSLContext.getInstance("TLS");
            sc.init(null, trustAllCerts, new java.security.SecureRandom());
            HttpsURLConnection
                    .setDefaultSSLSocketFactory(sc.getSocketFactory());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public final static HostnameVerifier DO_NOT_VERIFY = new HostnameVerifier() {
        public boolean verify(String hostname, SSLSession session) {
            return true;
        }
    };


}
