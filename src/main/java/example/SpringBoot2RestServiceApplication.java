package example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;

@SpringBootApplication
@EnableWebSecurity
public class SpringBoot2RestServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringBoot2RestServiceApplication.class, args);
    }
}