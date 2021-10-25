package com.figpop.demoopenfeign.external.config;

import okhttp3.OkHttpClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableFeignClients(basePackages = "com.figpop.demoopenfeign.external")
public class FeignConfig {
    // change https to ok http client
    @Bean
    public OkHttpClient client() {
        return new OkHttpClient();
    }
}
