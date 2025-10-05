package com.intership.codehub.config;


import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwaggerConfiguration {

    @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI()
                .info(new Info()
                        .title("CodeHub API Documentation")
                        .description("This is the API documentation for the CodeHub Platform")

                        .version("1.0.0")
                        .contact(new Contact()
                                .name("Sameer Sharma")
                                .email("itsofficial7014@gmail.com")
                                .url("http://localhost:8080")));

    }
}
