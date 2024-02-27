package dev.dubhe.fantasyskinserver.service;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import dev.dubhe.fantasyskinserver.config.BasicConfig;
import dev.dubhe.fantasyskinserver.configuration.DataSourceConfiguration;
import dev.dubhe.fantasyskinserver.data.DataSourceContextHolder;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Map;

import static dev.dubhe.fantasyskinserver.configuration.DataSourceConfiguration.DATABASE_URL;

@Component
public class InitializationService {
    private final DataSource routingDataSource;
    private static final Gson GSON = new GsonBuilder()
            .setPrettyPrinting()
            .create();
    public static BasicConfig config = null;

    @Autowired
    public InitializationService(DataSource routingDataSource) {
        this.routingDataSource = routingDataSource;
    }

    @PostConstruct
    public void load() {
        loadConfig();
        loadDataSource();
    }

    private void loadConfig() {
        File file = new File("./config.json");
        if (!file.isFile()) return;
        try (FileReader reader = new FileReader(file)) {
            config = GSON.fromJson(reader, BasicConfig.class);
        } catch (IOException ignored) {
        }
    }

    private void loadDataSource() {
        if (!(routingDataSource instanceof DataSourceConfiguration.DynamicRoutingDataSource dataSource)) return;
        BasicConfig.DataBaseConfig config;
        if (InitializationService.config == null) return;
        if (InitializationService.config.database == null) return;
        config = InitializationService.config.database;
        Map<Object, Object> targetDataSources = DataSourceContextHolder.getTargetDataSources();
        DriverManagerDataSource source = new DriverManagerDataSource();
        source.setDriverClassName("com.mysql.cj.jdbc.Driver");
        source.setUrl(DATABASE_URL.formatted(config.host, config.port, config.basename));
        source.setUsername(config.username);
        source.setPassword(config.password);
        targetDataSources.put("config", source);
        dataSource.setTargetDataSources(targetDataSources);
        DataSourceContextHolder.setDataSourceKey("config");
    }
}
