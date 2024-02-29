package dev.dubhe.fantasyskinserver.config;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.io.monitor.FileAlterationMonitor;
import org.apache.commons.io.monitor.FileAlterationObserver;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import java.io.File;

@Slf4j
@RequiredArgsConstructor
@Component
public class ContextFileListener implements ApplicationListener<ContextRefreshedEvent>, InitializingBean {
    private final FileAlterationMonitor monitor = new FileAlterationMonitor(1000);;
    private final File path = new File("config");

    private final ConfigFileListener listener;

    @Override
    public void afterPropertiesSet() {
        FileAlterationObserver observer = new FileAlterationObserver(path);
        observer.addListener(this.listener);
        monitor.addObserver(observer);
    }

    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {
        if (event.getApplicationContext().getParent() == null) {
            try {
                monitor.start();
            } catch (Exception e) {
                log.error("Error", e);
            }
        }
    }

}
