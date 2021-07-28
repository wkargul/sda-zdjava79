package pl.sdacademy.java.spring.hellosecurity.workshop4to5;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfiguration implements WebMvcConfigurer {

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry
//                .addMapping("/users")
                .addMapping("/**")
                .allowedOrigins("*")
                .allowedMethods("GET", "POST");
//                .allowedMethods("*")
    }
}
