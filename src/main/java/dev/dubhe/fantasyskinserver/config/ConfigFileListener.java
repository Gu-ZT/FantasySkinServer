package dev.dubhe.fantasyskinserver.config;

import lombok.RequiredArgsConstructor;
import org.apache.commons.io.monitor.FileAlterationListener;
import org.apache.commons.io.monitor.FileAlterationObserver;
import org.springframework.cloud.context.refresh.ContextRefresher;
import org.springframework.stereotype.Component;

import java.io.File;

@RequiredArgsConstructor
@Component
public class ConfigFileListener implements FileAlterationListener {

    private final ContextRefresher refresher;

    @Override
    public void onFileChange(File file) {
        String name = file.getName();
        if ("application-config.yml".equals(name)) {
            this.refresher.refresh();
        }
    }

    @Override
    public void onDirectoryChange(File file) {
    }

    @Override
    public void onDirectoryCreate(File file) {
    }

    @Override
    public void onDirectoryDelete(File file) {
    }

    @Override
    public void onFileCreate(File file) {
    }

    @Override
    public void onFileDelete(File file) {
    }

    @Override
    public void onStart(FileAlterationObserver fileAlterationObserver) {
    }

    @Override
    public void onStop(FileAlterationObserver fileAlterationObserver) {
    }
}
