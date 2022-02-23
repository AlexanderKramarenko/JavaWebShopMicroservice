package ru.alexander_kramarenko.java_web_shop_v11.gateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.reactive.config.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

// https://cloud.spring.io/spring-cloud-gateway/reference/html/

@SpringBootApplication
public class GatewayApp {
    public static void main(String[] args) {
        SpringApplication.run(GatewayApp.class, args);
    }

//    @Bean
//    public WebMvcConfigurer corsConfigurer() {
//        return new WebMvcConfigurer() {
//         //   @Override
//            public void addCorsMappings(CorsRegistry registry) {
//                registry.addMapping("http://localhost:5555/auth/api/v1/auth").allowedOrigins("http://localhost:3000/market/");
//
//             //   http://localhost:5555/auth/api/v1/auth
//            }
//        };
//    }
//

}
