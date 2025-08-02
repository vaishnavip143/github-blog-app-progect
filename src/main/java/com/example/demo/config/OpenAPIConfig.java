package com.example.demo.config;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.enums.SecuritySchemeType;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.info.License;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.security.SecurityScheme;
import org.springframework.context.annotation.Configuration;

@Configuration
@OpenAPIDefinition(
        info = @Info(
                title = "Blog App API",
                version = "1.0",
                description = "This project is developed by Vaishnavi Patil",
                termsOfService = "https://vaishnavipatil.com/terms",
                contact = @Contact(
                        name = "Vaishnavi Patil",
                        email = "vaishnavipatil@email.com",
                        url = "https://vaishnavipatil.com"
                ),
                license = @License(
                        name = "API License",
                        url = "https://vaishnavipatil.com/license"
                )
        ),
        security = @SecurityRequirement(name = "bearerAuth")  // Applies JWT globally to all endpoints
)
@SecurityScheme(
        name = "bearerAuth",               // Must match name in @SecurityRequirement
        type = SecuritySchemeType.HTTP,   // HTTP auth
        scheme = "bearer",                // Bearer scheme
        bearerFormat = "JWT"              // Format shown in UI
)
public class OpenAPIConfig {
}
