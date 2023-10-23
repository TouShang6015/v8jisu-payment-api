package org.hootin.v8jisu.properties;

import org.springframework.util.StringUtils;
import org.hootin.v8jisu.constants.Constant;

/**
 * api客户端参数配置
 *
 * @author WuHao
 * @since 2023/10/23 10:43
 */
public class V8ClientConfig {

    /**
     * 请求超时时间（秒）
     */
    private static int apiExpireTimeSeconds = 25;
    /**
     * 最大请求队列长度
     */
    private static int maxApiConnect = 20;

    public static int getApiExpireTimeSeconds() {
        return apiExpireTimeSeconds;
    }

    public static int getMaxApiConnect() {
        return maxApiConnect;
    }

    public static void resetConfig() {
        String prefix = Constant.propertiesPrefix + ".client.";
        String apiExpireTimeSeconds = System.getProperty(prefix + "apiExpireTimeSeconds");
        if (!StringUtils.containsWhitespace(apiExpireTimeSeconds)) {
            V8ClientConfig.apiExpireTimeSeconds = Integer.parseInt(apiExpireTimeSeconds);
        }
        String maxApiConnect = System.getProperty(prefix + "maxApiConnect");
        if (!StringUtils.containsWhitespace(maxApiConnect)) {
            V8ClientConfig.maxApiConnect = Integer.parseInt(maxApiConnect);
        }
    }

}
