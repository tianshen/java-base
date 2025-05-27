/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.base;

import java.io.UnsupportedEncodingException;
import java.util.Iterator;
import java.util.Map;
import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;

/**
 *
 * @author guoxinhua
 */
public class Demo {
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws Exception {

        //创建post参数不包含signature 密码不需要md5
        String password = "039e3beb";

        Map<String, String> paras = new java.util.HashMap<>();
        paras.put("sp_id", "497680");
        paras.put("mobile", "19000000000");
        paras.put("content", "【辉煌国际】尊敬的王川 先生/女士您好，您办理的车辆融租业务第 1 期租金1元到期未足额还款并产生一次逾期，逾期信息将报送人民银行征信系统，请注意后期的还款，避免再次出现逾期。咨询热线 010-1111");
        //根据参数Key排序（顺序）
        java.util.TreeMap<String, String> sortParas = new java.util.TreeMap<>();
        sortParas.putAll(paras);

        String sortedQueryString = specialUrlEncode(http_build_query(sortParas));

        //将上面得到的字符串按照如下顺序拼接成新的字符串
        StringBuilder stringToSign = new StringBuilder();
        stringToSign.append("POST").append("&");
        stringToSign.append(toUtf8("/")).append("&");
        stringToSign.append(sortedQueryString);

        //签名采用HmacSHA1算法 + Base64。参考代码如下：
        String sign = getSignature(stringToSign.toString(), password);

        System.out.println(sign);
    }

    public static String toUtf8(String value) throws Exception {
        return java.net.URLEncoder.encode(value, "UTF-8");
    }

    public static String specialUrlEncode(String value) throws Exception {
        return value.replace("+", "%20").replace("*", "%2A").replace("%7E", "~");
    }

    public static String getSignature(String data, String key) throws Exception {
        byte[] keyBytes = key.getBytes();

        SecretKeySpec signingKey = new SecretKeySpec(keyBytes, "HmacSHA1");

        Mac mac = Mac.getInstance("HmacSHA1");

        mac.init(signingKey);

        byte[] rawHmac = mac.doFinal(data.getBytes());

        String hexBytes = byte2hex(rawHmac);

        return new sun.misc.BASE64Encoder().encode(hexBytes.getBytes());
    }

    private static String byte2hex(final byte[] b) {
        String hs = "";

        String stmp = "";

        for (int n = 0; n < b.length; n++) {

            stmp = (Integer.toHexString(b[n] & 0xFF));

            if (stmp.length() == 1) {
                hs = hs + "0" + stmp;

            } else {
                hs = hs + stmp;

            }

        }

        return hs;

    }

    /**
     * Java实现PHP中的http_build_query()效果
     *
     * @param array key=value形式的二位数组
     * @return
     */
   public static String http_build_query(Map<String, String> array) {
        String reString = null;
        //遍历数组形成akey=avalue&bkey=bvalue&ckey=cvalue形式的的字符串
        Iterator it = array.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry<String, String> entry = (Map.Entry) it.next();
            String key = entry.getKey();
            String value = entry.getValue();
            reString += key + "=" + value + "&";
        }
        reString = reString.substring(0, reString.length() - 1);
        //将得到的字符串进行处理得到目标格式的字符串
        try {
            reString = java.net.URLEncoder.encode(reString, "utf-8");
        } catch (UnsupportedEncodingException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        reString = reString.replace("%3D", "=").replace("%26", "&");

        // 去除第一个多余的null符号
        return reString.substring(4);

    }

}

