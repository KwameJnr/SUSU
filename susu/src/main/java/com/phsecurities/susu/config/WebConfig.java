package com.phsecurities.susu.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.method.HandlerTypePredicate;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.PathMatchConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@PropertySource("classpath:application.properties") // application.properties is the source of @Value
@EnableAsync
@Configuration
public class WebConfig  implements WebMvcConfigurer {

    @Value("${target.deployment.stage}")
    private String targetDeploymentStage;

    @Override
    public void configurePathMatch(PathMatchConfigurer configurer) {
        configurer.addPathPrefix("/pledgepayservice/" + targetDeploymentStage,
                HandlerTypePredicate.forAnnotation(RestController.class));
    }

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")
                .allowedOrigins("*")
                .allowedMethods("GET", "POST", "PUT", "PATCH")
                .maxAge(36000);
    }
}

