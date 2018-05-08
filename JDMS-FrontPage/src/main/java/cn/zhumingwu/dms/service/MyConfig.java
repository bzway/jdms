package cn.zhumingwu.dms.service;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MyConfig  {
    @Bean(name = "urlService")
    public UrlService urlService() {
        return () -> "domain.com/myapp";
    }
}