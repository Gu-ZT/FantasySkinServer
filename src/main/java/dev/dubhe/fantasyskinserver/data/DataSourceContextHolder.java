package dev.dubhe.fantasyskinserver.data;

import lombok.Getter;
import lombok.Setter;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class DataSourceContextHolder {
    @Getter
    private static final Map<Object, Object> targetDataSources = new ConcurrentHashMap<>();
    @Getter
    @Setter
    private static String dataSourceKey = "default";
}
