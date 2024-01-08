package org.hootin.v8jisu.sign;

import org.hootin.v8jisu.properties.V8AccountConfig;

import java.lang.reflect.Field;
import java.security.MessageDigest;
import java.util.*;

/**
 * @author WuHao
 * @since 2024/1/8 10:25
 */
public class SignUtil2 {

    public static <T> String getSign(T t) {
        Map<String, String> map = beanToMap(t);
        return generateSign(map, V8AccountConfig.getAppKey());
    }

    public static String generateSign(Map<String, String> params, String key) {
        // 按照参数名ASCII码从小到大排序
        List<String> keys = new ArrayList<>(params.keySet());
        Collections.sort(keys);

        // 拼接参数
        StringBuilder sb = new StringBuilder();
        for (String k : keys) {
            String value = params.get(k);
            if (!"sign".equals(k) && !"sign_type".equals(k) && value != null && !"".equals(value)) {
                sb.append(k).append("=").append(value).append("&");
            }
        }
        sb.append("key=").append(key);

        // 计算MD5摘要
        try {
            MessageDigest md5 = MessageDigest.getInstance("MD5");
            byte[] digest = md5.digest(sb.toString().getBytes());
            StringBuilder result = new StringBuilder();
            for (byte b : digest) {
                result.append(Integer.toHexString(b & 0xff));
            }
            return result.toString();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 对象转Map
     *
     * @param object
     * @return
     * @throws IllegalAccessException
     */
    public static <T> Map<String, String> beanToMap(T object) {
        Map<String, String> map = new HashMap<>();
        Field[] fields = object.getClass().getDeclaredFields();
        for (Field field : fields) {
            field.setAccessible(true);
            try {
                map.put(field.getName(), (String) field.get(object));
            } catch (IllegalAccessException e) {
                e.printStackTrace();
                throw new RuntimeException("对象转换Map异常");
            }
        }
        return map;
    }

}
