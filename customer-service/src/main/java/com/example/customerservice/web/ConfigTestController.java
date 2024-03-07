package com.example.customerservice.web;

import com.example.customerservice.config.GlobalConfig;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RefreshScope
public class ConfigTestController {
    @Value("${global.params.p1}")
    private int p1;

    @Value("${global.params.p2}")
    private int p2;

    @Value("${customer.service.x}")
    private int x;

    @Value("${customer.service.y}")
    private int y;

    private final GlobalConfig globalConfig;

    public ConfigTestController(GlobalConfig globalConfig) {
        this.globalConfig = globalConfig;
    }

    @GetMapping("/testConfig")
    public Map<String,Integer> configTest() {
        return Map.of("p1",p1,"p2",p2,"x",x,"y",y);
    }

    @GetMapping("/testGlobalConfig")
    public GlobalConfig globalConfigTest() {
        return globalConfig;
    }
}
