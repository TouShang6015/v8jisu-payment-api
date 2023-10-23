package org.v8jisu.sign;

import org.springframework.util.DigestUtils;
import org.v8jisu.properties.V8AccountConfig;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.StringJoiner;

/**
 * 签名工具类
 *
 * @author WuHao
 * @since 2023/10/23 11:30
 */
public class SignUtil {

    public static <T> String getSign(T t) {
        Map<String, Object> sortMap = sortByKey(beanToMap(t));
        StringJoiner sj = new StringJoiner("&");
        sortMap.forEach((k, v) -> {
            sj.add(String.format("%s=%s", k, v));
        });
        String value = sj.toString();
        value = value + V8AccountConfig.getAppKey();
        return DigestUtils.md5DigestAsHex(value.getBytes());
    }


    /**
     * map key 排序
     *
     * @param map
     * @param <K>
     * @param <V>
     * @return
     */
    public static <K extends Comparable<? super K>, V> Map<K, V> sortByKey(Map<K, V> map) {
        Map<K, V> result = new LinkedHashMap<>();
        map.entrySet().stream()
                .sorted(Map.Entry.<K, V>comparingByKey()).forEachOrdered(e -> result.put(e.getKey(), e.getValue()));
        return result;
    }

    /**
     * 对象转Map
     *
     * @param object
     * @return
     * @throws IllegalAccessException
     */
    public static <T> Map<String, Object> beanToMap(T object) {
        Map<String, Object> map = new HashMap<>();
        Field[] fields = object.getClass().getDeclaredFields();
        for (Field field : fields) {
            field.setAccessible(true);
            try {
                map.put(field.getName(), field.get(object));
            } catch (IllegalAccessException e) {
                e.printStackTrace();
                throw new RuntimeException("对象转换Map异常");
            }
        }
        return map;
    }

}
