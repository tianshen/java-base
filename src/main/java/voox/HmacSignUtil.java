package voox;

import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.exception.ExceptionUtils;
import lombok.extern.slf4j.Slf4j;
import java.nio.charset.StandardCharsets;
import java.util.*;

/**
 * @Author: Rookie
 * @Date: 2025/8/25 16:45
 * @Describe:
 */
@Slf4j
public class HmacSignUtil {

    /**
     * 默认 HMAC 算法
     */
    private static final String HMAC_ALGORITHM = "HmacSHA256";

    private static final String signKey = "6LesuNoqAAAAADOSW8M4ITYNqsJ1lXb5tCjflmSy";

    public static void main(String[] args) {

        VooxVerifyTokenParam params = new VooxVerifyTokenParam();
        params.setToken("82e515eb1f684790861946dd33d76af8");
        params.setTimestamp(1757055793510L);

//        VooxCompleteParam params = new VooxCompleteParam();
//        params.setXmeUid("18123621592618");
//        params.setVooxUid("vooxid");
//        params.setToken("75f67921d646430781b66cccbe0d8f02");
//        params.setTimestamp(1756955270881L);

        String signature = generateHexSignature(params, signKey);
        System.out.println(signature);
    }


    /**
     * 生成签名（Hex 格式）
     * @param params 待签名参数
     * @param key 对称秘钥
     * @return Hex 字符串
     */
    public static String generateHexSignature(Object params, String key) {
        byte[] hash = generateHmac(params, key);
        return hash == null ? "" : bytesToHex(hash);
    }
    /**
     * 生成签名（Base64 格式）
     * @param params 待签名参数
     * @param key 对称秘钥
     * @return Base64 字符串
     */
    public static String generateBase64Signature(Map<String, String> params, String key) {
        byte[] hash = generateHmac(params, key);
        return hash == null ? "" : Base64.getEncoder().encodeToString(hash);
    }

    /**
     * 验签（Hex 格式）
     * @param params 待签名参数
     * @param key 对称秘钥
     * @param signature 签名值（Hex）
     * @return true 验签成功
     */
    public static boolean verifyHexSignature(Object params, String key, String signature) {
        String computed = generateHexSignature(params, key);
        return computed.equalsIgnoreCase(signature);
    }
    /**
     * 验签（Base64 格式）
     * @param params 待签名参数
     * @param key 对称秘钥
     * @param signature 签名值（Base64）
     * @return true 验签成功
     */
    public static boolean verifyBase64Signature(Map<String, String> params, String key, String signature) {
        String computed = generateBase64Signature(params, key);
        return computed.equals(signature);
    }

    // ------------------- 内部方法 -------------------
    /**
     * 生成 HMAC-SHA256
     */
    public static byte[] generateHmac(Object params, String key) {
        try {
            // 1. 拼接参数字符串（按 key 排序 + 递归处理）
            String dataCheckString = JsonSignUtils.toSortedString(params);
            if (StringUtils.isBlank(dataCheckString)) {
                return null;
            }

            // 2. 初始化 HMAC（直接使用原始 key）
            Mac mac = Mac.getInstance(HMAC_ALGORITHM);
            SecretKeySpec keySpec = new SecretKeySpec(key.getBytes(StandardCharsets.UTF_8), HMAC_ALGORITHM);
            mac.init(keySpec);

            // 3. 生成签名
            return mac.doFinal(dataCheckString.getBytes(StandardCharsets.UTF_8));
        } catch (Exception e) {
            log.error("generateHmac error, key: {}, params: {}, error: {}", key, params, ExceptionUtils.getStackTrace(e));
        }
        return null;
    }

    /**
     * 字节数组转 Hex
     */
    private static String bytesToHex(byte[] bytes) {
        StringBuilder sb = new StringBuilder();
        for (byte b : bytes) {
            sb.append(String.format("%02x", b));
        }
        return sb.toString();
    }

}