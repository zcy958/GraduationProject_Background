package com.niit.gamecenter_common.safe;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix = "aliyun")
@Data
public class AliyunProperties {
    private String accessKey;//aliyun.accesskey
    private String secret;//aliyun.secret
    private String scenes; //aliyun.scenes
}
