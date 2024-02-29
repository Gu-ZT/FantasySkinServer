package dev.dubhe.fantasyskinserver.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.context.annotation.Configuration;

@RefreshScope
@Configuration
@ConfigurationProperties(prefix = "app")
public class DataBaseConfig {
    private String host;
    private Integer port;
    private String database;
    private String username;
    private String password;

}
