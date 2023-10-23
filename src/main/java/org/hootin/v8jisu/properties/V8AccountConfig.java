package org.hootin.v8jisu.properties;

import lombok.Data;

/**
 * 商户配置类
 *
 * @author WuHao
 * @since 2023/10/23 10:43
 */
@Data
public class V8AccountConfig {

    /**
     * 商户id
     */
    private static String appId;
    /**
     * 商户密钥
     */
    private static String appKey;

    public static String getAppId() {
        return appId;
    }

    public static String getAppKey() {
        return appKey;
    }

    public static void setAppId(String appId) {
        V8AccountConfig.appId = appId;
    }

    public static void setAppKey(String appKey) {
        V8AccountConfig.appKey = appKey;
    }

}
