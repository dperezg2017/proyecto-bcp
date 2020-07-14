package com.example.bcp.config;

import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;


@Configuration
@EnableConfigurationProperties({
        TipoCambioProperties.class})
public class ConfigServerProperties {
}
