package dev.dubhe.fantasyskinserver.service;

import dev.dubhe.fantasyskinserver.config.DataBaseConfig;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class TestService {

    private final DataBaseConfig config;
}
