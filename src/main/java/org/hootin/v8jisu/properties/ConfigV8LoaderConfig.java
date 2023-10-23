package org.hootin.v8jisu.properties;

import org.hootin.v8jisu.constants.Constant;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

import java.util.Objects;

@Component
public class ConfigV8LoaderConfig implements InitializingBean {

    @Autowired
    private Environment environment;

    @Override
    public void afterPropertiesSet() throws Exception {
        // api client config
        String clientPrefix = Constant.propertiesPrefix + ".client.";
        String apiExpireTimeSeconds = environment.getProperty(clientPrefix + "apiExpireTimeSeconds");
        if (Objects.nonNull(apiExpireTimeSeconds)) {
            V8ClientConfig.setApiExpireTimeSeconds(Integer.parseInt(apiExpireTimeSeconds));
        }
        String maxApiConnect = environment.getProperty(clientPrefix + "maxApiConnect");
        if (Objects.nonNull(maxApiConnect)) {
            V8ClientConfig.setMaxApiConnect(Integer.parseInt(maxApiConnect));
        }
        // api account config
        String accountPrefix = Constant.propertiesPrefix + ".account.";
        String appId = environment.getProperty(accountPrefix + "appId");
        if (Objects.nonNull(appId)) {
            V8AccountConfig.setAppId(appId);
        }
        String appKey = environment.getProperty(accountPrefix + "appKey");
        if (Objects.nonNull(appKey)) {
            V8AccountConfig.setAppKey(appKey);
        }
    }
}