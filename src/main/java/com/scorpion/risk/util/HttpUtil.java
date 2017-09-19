package com.scorpion.risk.util;

import com.scorpion.risk.constant.Constant;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.crypto.Mac;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.text.SimpleDateFormat;
import java.util.Base64;
import java.util.Calendar;
import java.util.Locale;
import java.util.TimeZone;

/**
 * Created on 2017/9/18.
 */
public class HttpUtil {


    private static final Logger LOGGER = LoggerFactory.getLogger(HttpUtil.class);


    public static String get(String donationId) {
        HttpURLConnection conn = null;
        try {
            String date = getGMT();
            String version = "1.0";
            String str = "GET" + "\n"
                    + date + "\n"
                    + "x-zjb-date:" + date + "\n"
                    + "x-zjb-version:" + version + "\n"
                    + Constant.ENDPOINT + donationId;
            String signature = enCryptToSHA1(str, Constant.ACCESS_KEY_SECRET);
            String address = Constant.DONATION_URL + "/api/" + Constant.ENDPOINT + donationId;
            URL url = new URL(address);
            conn = (HttpURLConnection) url.openConnection();
            conn.setReadTimeout(5 * 60 * 1000);
            conn.setRequestMethod("GET");

            conn.setRequestProperty("Content-type", "application/json");
            conn.setRequestProperty("Authorization", "ZJB You AccessKey:" + signature);
            conn.setRequestProperty("Date", date);
            conn.setRequestProperty("x-zjb-date", date);
            conn.setRequestProperty("x-zjb-version", version);
            conn.connect();

            int responseCode = conn.getResponseCode();
            BufferedReader reader = new BufferedReader(new InputStreamReader(conn.getInputStream(), "UTF-8"));
            StringBuffer response = new StringBuffer();
            String inputLine;
            while ((inputLine = reader.readLine()) != null) {
                response.append(inputLine);
            }
            reader.close();
            return response.toString();
        } catch (Exception e) {
            LOGGER.error("接口出错------>", e);
            e.printStackTrace();
        } finally {
            try {
                if (conn != null) {
                    conn.disconnect();
                }
            } catch (Exception e) {
                LOGGER.error("关闭连接出错------>", e);
            }
        }
        return null;
    }

    /**
     * 获取GMT 时间
     *
     * @return
     */
    static String getGMT() {
        SimpleDateFormat sdf = new SimpleDateFormat("EEE d MMM yyyy HH:mm:ss 'GMT'", Locale.US);
        sdf.setTimeZone(TimeZone.getTimeZone("GMT"));
        Calendar calendar = Calendar.getInstance();
        String date = sdf.format(calendar.getTime());
        return date;
    }

    /**
     * 签名加密
     *
     * @param encryptText 加密字符串
     * @param encryptKey  加密秘钥
     * @return
     */
    static String enCryptToSHA1(String encryptText, String encryptKey) throws UnsupportedEncodingException, NoSuchAlgorithmException, InvalidKeyException {

        byte[] data = encryptKey.getBytes("UTF-8");
        SecretKey secretKey = new SecretKeySpec(data, "HmacSHA1");
        Mac mac = Mac.getInstance("HmacSHA1");
        mac.init(secretKey);
        byte[] text = encryptText.getBytes("UTF-8");
        byte[] payload = mac.doFinal(text);
        return Base64.getEncoder().encodeToString(payload);
    }
}
