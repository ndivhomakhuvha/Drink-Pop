package com.birimarung.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")
                .allowedOrigins("http://localhost:4200", "https://drink-pop.vercel.app")  // Allow both localhost and Vercel
                .allowedMethods("GET", "POST", "PUT", "DELETE", "OPTIONS")  // Allow these methods
                .allowedHeaders("*")  // Allow all headers
                .exposedHeaders("Authorization")  // Expose Authorization header if needed
                .allowCredentials(true);
    }
}