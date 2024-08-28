package pl.arturzgodka.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity security) throws  Exception {

        security
                .authorizeHttpRequests((requests) -> requests.requestMatchers("/", "/register", "/login", "/skills/**", "/items/**", "/css/**", "/font/**","/img/**")
                .permitAll()
                        .anyRequest()
                        .authenticated());

        return security.build();
    }
}
