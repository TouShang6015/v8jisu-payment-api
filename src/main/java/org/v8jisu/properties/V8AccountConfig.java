package org.v8jisu.properties;

import lombok.Data;
import org.springframework.util.StringUtils;
import org.v8jisu.constants.Constant;

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

    public static void resetConfig() {
        String prefix = Constant.propertiesPrefix + ".account.";
        String appId = System.getProperty(prefix + "appId");
        if (!StringUtils.containsWhitespace(appId)) {
            V8AccountConfig.appId = appId;
        }
        String appKey = System.getProperty(prefix + "appKey");
        if (!StringUtils.containsWhitespace(appKey)) {
            V8AccountConfig.appKey = appKey;
        }
    }

}
