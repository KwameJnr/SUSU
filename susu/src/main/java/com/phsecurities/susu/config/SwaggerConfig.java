package com.phsecurities.susu.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.enums.SecuritySchemeType;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.security.SecurityScheme;
import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.security.SecurityRequirement;
// import io.swagger.v3.oas.models.security.SecurityScheme.BearerFormat;
import io.swagger.v3.oas.models.security.SecurityScheme.Type;

@Configuration
@SecurityScheme(
    name = "Bearer Authentication",
    type = SecuritySchemeType.HTTP,
    bearerFormat = "JWT",
    scheme = "bearer"
)
@OpenAPIDefinition(
    info = @Info(
        title = "Pledge Pay App Backend-Manager",
        version = "1.0.0",
        description = "API documentation for Pledge Pay App Backend-Manager",
        contact = @Contact(name = "Dev Team", email = "support@phsecurities.com")
    )
)
public class SwaggerConfig {

    @Bean
    public OpenAPI openAPI() {
        return new OpenAPI()
            .addSecurityItem(new SecurityRequirement().addList("Bearer Authentication"))
            .components(new Components()
                .addSecuritySchemes("Bearer Authentication",
                    new io.swagger.v3.oas.models.security.SecurityScheme()
                        .name("Bearer Authentication")
                        .type(Type.HTTP)
                        .scheme("bearer")
                        .bearerFormat("JWT")
                ));
    }
}
