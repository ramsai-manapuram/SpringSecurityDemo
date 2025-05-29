package com.flipkart.flipkart.config;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Bean
    public PasswordEncoder getPasswordEncoder() {
        return new BCryptPasswordEncoder();
    }

    // @Bean
    // public UserDetailsService userDetailsService() {
    //     UserDetails user1 = User.withUsername("Arun")
    //             .password(new BCryptPasswordEncoder().encode("Password@1234"))
    //             .roles("ADMIN")
    //             .build();

    //     UserDetails user2 = User.withUsername("Varun")
    //             .password(new BCryptPasswordEncoder().encode("Password@345"))
    //             .roles("USER")
    //             .build();     

    //     return new InMemoryUserDetailsManager(user1, user2);
    // }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        // Just skipping the register end point alone from authentication
        http.authorizeHttpRequests(auth -> auth
                    .requestMatchers("/auth/register").permitAll()
                    .anyRequest().authenticated()
                )      
                .csrf(csrf -> csrf.disable())
                .httpBasic(Customizer.withDefaults());
        return http.build(); 
    }

}
