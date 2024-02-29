package dev.dubhe.fantasyskinserver.config;

import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.cloud.autoconfigure.RefreshAutoConfiguration;
import org.springframework.cloud.context.refresh.ConfigDataContextRefresher;
import org.springframework.cloud.context.refresh.ContextRefresher;
import org.springframework.cloud.context.scope.refresh.RefreshScope;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanRegistry {

    @Bean
    @ConditionalOnMissingBean(RefreshScope.class)
    public static RefreshScope refreshScope() {
        return new RefreshScope();
    }

    @Bean
    @ConditionalOnMissingBean
    public ContextRefresher contextRefresher(ConfigurableApplicationContext context,
                                             RefreshScope scope) {
        return new ConfigDataContextRefresher(context, scope, new RefreshAutoConfiguration.RefreshProperties());
    }
}
