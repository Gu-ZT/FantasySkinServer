package dev.dubhe.fantasyskinserver.controller;

import dev.dubhe.fantasyskinserver.data.DataSourceContextHolder;
import dev.dubhe.fantasyskinserver.data.ResponseResult;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api")
public class BaseController {
    @GetMapping("/status")
    public ResponseResult status() {
        return ResponseResult.success(DataSourceContextHolder.getDataSourceKey().equals("config") ? "ready" : "init");
    }
}
