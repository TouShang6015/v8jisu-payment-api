package org.hootin.v8jisu.client;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.SerializationFeature;
import okhttp3.ConnectionPool;
import okhttp3.OkHttpClient;
import org.hootin.v8jisu.api.Api;
import org.hootin.v8jisu.constants.Constant;
import org.hootin.v8jisu.properties.V8AccountConfig;
import org.hootin.v8jisu.properties.V8ClientConfig;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.jackson.JacksonConverterFactory;

import java.util.concurrent.TimeUnit;

/**
 * 支付客户端请求入口
 *
 * @author WuHao
 * @since 2023/10/23 10:59
 */
public class V8PayClient {

    public static OkHttpClient getClient() {

        int apiExpireTimeSeconds = V8ClientConfig.getApiExpireTimeSeconds();
        return new OkHttpClient.Builder()
                .connectTimeout(apiExpireTimeSeconds, TimeUnit.SECONDS)
                .writeTimeout(apiExpireTimeSeconds, TimeUnit.SECONDS)
                .readTimeout(apiExpireTimeSeconds, TimeUnit.SECONDS)
                .connectionPool(new ConnectionPool(V8ClientConfig.getMaxApiConnect(), apiExpireTimeSeconds, TimeUnit.SECONDS)).build();
    }

    /**
     * 创建支付服务实例
     *
     * @return
     */
    public static V8ApiService createService() {
        OkHttpClient client = getClient();

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(Constant.host)
                .client(client)
                .addConverterFactory(JacksonConverterFactory.create(defaultObjectMapper()))
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build();

        return new V8ApiService(retrofit.create(Api.class));

    }

    public static ObjectMapper defaultObjectMapper() {
        ObjectMapper mapper = new ObjectMapper();
        mapper.disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);
        mapper.disable(SerializationFeature.FAIL_ON_EMPTY_BEANS);
        mapper.disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);
        mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        mapper.setSerializationInclusion(JsonInclude.Include.NON_NULL);
        mapper.setPropertyNamingStrategy(PropertyNamingStrategies.SNAKE_CASE);
        return mapper;
    }

}
