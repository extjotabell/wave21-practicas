package com.Empleados.Empleados.config;

import org.apache.http.HttpHost;
import org.elasticsearch.client.RestClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.elasticsearch.repository.config.EnableElasticsearchRepositories;

@Configuration
@EnableElasticsearchRepositories(basePackages = "com.Empleados.Empleados.repositories")
public class Config {
    @Bean
    public RestClient client(){
        return RestClient.builder(
                new HttpHost("localhost",9200))
                .build();
    }
}
