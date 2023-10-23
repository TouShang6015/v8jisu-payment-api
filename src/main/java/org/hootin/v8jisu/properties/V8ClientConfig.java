package org.hootin.v8jisu.properties;

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

    public static void setApiExpireTimeSeconds(int apiExpireTimeSeconds) {
        V8ClientConfig.apiExpireTimeSeconds = apiExpireTimeSeconds;
    }

    public static void setMaxApiConnect(int maxApiConnect) {
        V8ClientConfig.maxApiConnect = maxApiConnect;
    }

}
