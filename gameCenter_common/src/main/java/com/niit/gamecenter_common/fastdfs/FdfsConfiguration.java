package com.niit.gamecenter_common.fastdfs;

import com.github.tobato.fastdfs.FdfsClientConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;

@Configuration
@PropertySource("classpath:fast_dfs.properties")
@Import(FdfsClientConfig.class)
@ConditionalOnProperty(name = "fastdfs.enable",havingValue = "true")
public class FdfsConfiguration {


    @Bean
    public FastDFSClientUtil getFastDFSClientUtil(){
        return new FastDFSClientUtil();
    }
}
