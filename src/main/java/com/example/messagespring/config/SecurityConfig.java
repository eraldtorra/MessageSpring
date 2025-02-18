package com.example.messagespring.config;


import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
public class SecurityConfig {

//    one method to create a bean of type UserDetailsService
//    private final UserRepository userRepository;
//
//    @Bean
//    public UserDetailsService userDetailsService() {
//        return new JpaUserDetailsService(userRepository);
//    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception{

        http.httpBasic(Customizer.withDefaults());

        http.authorizeHttpRequests( a -> a
                .requestMatchers("auth/**").permitAll()
                .anyRequest().authenticated());

        http.csrf(
                c -> c.ignoringRequestMatchers("/auth/**")
        );
      return http.build();
    }


    @Bean
    public PasswordEncoder passwordEncoder() {
        return NoOpPasswordEncoder.getInstance();
    }
}
