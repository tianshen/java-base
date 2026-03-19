package voox;

/**
 * @Author: Rookie
 * @Date: 2025/8/27 16:17
 * @Describe: 用于将对象转化为符合加签、验签的标准字符串，排除sign字段，Map中的也会根据字典序排序
 * requestId=20250826180001&timestamp=1756285386864&withdrawList=[amount=0.5&symbol=BTC&transId=tx123456&xmeUid=1001,amount=1.2&symbol=ETH&transId=tx123457&xmeUid=1002]
 */
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.*;
import org.apache.commons.lang3.exception.ExceptionUtils;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class JsonSignUtils {
    private static final ObjectMapper mapper = new ObjectMapper();

    /**
     * 对象转排序字符串（用于签名）
     * 规则：
     * - 过滤 null 值
     * - 保留空字符串 ("")，拼接为 k=
     * - 保留空数组 []，拼接为 k=[]
     * - 过滤 sign 字段
     * - 按 key 升序拼接
     */
    public static String toSortedString(Object obj) {
        try {
            JsonNode jsonNode = mapper.valueToTree(obj);
            return buildString(jsonNode);
        } catch (Exception e) {
            log.error("JsonSignUtils toSortedString error, obj: {}, error: {}", obj, ExceptionUtils.getStackTrace(e));
        }
        return "";
    }

    private static String buildString(JsonNode node) {
        if (node == null || node.isNull()) {
            // 🚨 null 值直接忽略
            return null;
        }

        if (node.isObject()) {
            List<String> parts = new ArrayList<>();
            node.fieldNames().forEachRemaining(field -> {
                if (!"sign".equals(field)) { // 🚨 过滤 sign
                    String val = buildString(node.get(field));
                    if (val != null) { // 🚨 过滤 null 值字段
                        parts.add(field + "=" + val);
                    }
                }
            });
            Collections.sort(parts);
            return String.join("&", parts);
        } else if (node.isArray()) {
            if (node.size() == 0) {
                return "[]"; // 🚨 空数组保留
            }
            List<String> arrParts = new ArrayList<>();
            for (JsonNode sub : node) {
                String val = buildString(sub);
                if (val != null) {
                    arrParts.add(val);
                }
            }
            return "[" + String.join(",", arrParts) + "]";
        } else {
            // 🚨 普通值，空字符串也会被保留
            return node.asText();
        }
    }
}
