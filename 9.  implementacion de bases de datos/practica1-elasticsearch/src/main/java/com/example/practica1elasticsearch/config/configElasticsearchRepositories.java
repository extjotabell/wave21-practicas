package com.example.practica1elasticsearch.config;

import org.apache.http.HttpHost;
import org.elasticsearch.client.RestClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.elasticsearch.repository.config.EnableElasticsearchRepositories;

@Configuration
@EnableElasticsearchRepositories(basePackages = "com.example.practica1elasticsearch.repository")
public class configElasticsearchRepositories {

    @Bean
    public RestClient client(){
        return RestClient.builder(
                        new HttpHost("localhost", 9200))
                .build();
    }
}
