package edu.hillel.newsapiproxyrestclient.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class Config {

    public static final String NEWS_API_PROXY_SERVICE_HOST = "http://localhost:7979/proxy/";

    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }
}
