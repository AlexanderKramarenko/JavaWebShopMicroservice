package ru.alexander_kramarenko.java_web_shop_v11.auth;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@SpringBootApplication
public class SpringWebAppAuthApplication {
	public static void main(String[] args) {
		SpringApplication.run(SpringWebAppAuthApplication.class, args);
	}

	    @Bean
    public WebMvcConfigurer corsConfigurer() {
        return new WebMvcConfigurer() {
            @Override
            public void addCorsMappings(CorsRegistry registry) {
                registry.addMapping("/api/v1/auth").allowedOrigins("http://localhost:3000");
				registry.addMapping("/api/v1/users").allowedOrigins("http://localhost:3000");
				registry.addMapping("/me").allowedOrigins("http://localhost:3000");


				//   http://localhost:5555/auth/api/v1/auth
            }
        };
    }

}
