package com.niit.gamecenter_common.config;

import com.niit.gamecenter_common.safe.AliyunProperties;
import com.niit.gamecenter_common.safe.AliyunSafeTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableConfigurationProperties(AliyunProperties.class)
@ConditionalOnProperty(name = "aliyun.accessKey")
public class AliyunSafeConfiguration {

    @Autowired
    private AliyunProperties aliyunProperties;

    @Bean
    public AliyunSafeTemplate getAliyunSafeTemplate(){
        return new AliyunSafeTemplate(aliyunProperties);
    }
}
