package dev.dubhe.fantasyskinserver.configuration;

import dev.dubhe.fantasyskinserver.data.DataSourceContextHolder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;

import javax.sql.DataSource;
import java.util.Map;

@Configuration
public class DataSourceConfiguration {
    public static final String DATABASE_URL = "jdbc:mysql://%s:%s/%s?museUnicode=true&characterEncoding=utf-8";

    @Bean
    @Lazy
    public DataSource dataSource() {
        Map<Object, Object> targetDataSources = DataSourceContextHolder.getTargetDataSources();
        DriverManagerDataSource defaultDataSource = new DriverManagerDataSource();
        defaultDataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
        defaultDataSource.setUrl(DATABASE_URL.formatted("localhost", 3366, "fantasy_skin"));
        defaultDataSource.setUsername("");
        defaultDataSource.setPassword("");
        targetDataSources.put("default", defaultDataSource);
        DynamicRoutingDataSource dataSource = new DynamicRoutingDataSource();
        dataSource.setDefaultTargetDataSource(defaultDataSource);
        dataSource.setTargetDataSources(targetDataSources);
        return dataSource;
    }

    public static class DynamicRoutingDataSource extends AbstractRoutingDataSource {
        @Override
        protected Object determineCurrentLookupKey() {
            return DataSourceContextHolder.getDataSourceKey();
        }
    }
}
