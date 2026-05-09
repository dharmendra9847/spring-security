package com.itstech.dharm.springsecuritydemo.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsPasswordService;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    /*
     * I WANT TO CONNECT WITH THE DATABASE DYNAMICALLY
     * This UserDetailsService will fetch user data from database
     */
    private UserDetailsService userDetailsService;

    @Autowired
    public SecurityConfig(UserDetailsService userDetailsService) {
        this.userDetailsService = userDetailsService;
    }

    /*
     * Authentication Provider
     * Used to authenticate user from database
     */
    @Bean
    public AuthenticationProvider authProvider() {

        DaoAuthenticationProvider provider = new DaoAuthenticationProvider(userDetailsService);

        // Set custom UserDetailsService
        //provider.setUserDetailsService(userDetailsService); // OLDER VERSION
        //provider.setUserDetailsPasswordService((UserDetailsPasswordService) userDetailsService);

        // Set password encoder
        //provider.setPasswordEncoder(passwordEncoder());
        provider.setPasswordEncoder(NoOpPasswordEncoder.getInstance()); // OLDER VERSION

        return provider;
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) {

       /*   fix: resolve CSRF token validation issue    */
       http
            .csrf(
                    AbstractHttpConfigurer::disable)
            .authorizeHttpRequests(
                    auth -> auth.anyRequest().authenticated())
            .httpBasic(Customizer.withDefaults())
            .sessionManagement(
                    session ->
                            session.sessionCreationPolicy(SessionCreationPolicy.STATELESS));
        return http.build();
    }

    /*  Working with Multiple Users */
    /*  THESE UserDetailsService WORK WITH STATIC VALUE */
    /* I don't want to work with static values now. */
/*    @Bean
    public UserDetailsService userDetailsService() {

        UserDetails user = User
                .withDefaultPasswordEncoder()
                .username("dharm")
                .password("dharm@123")
                .roles("USER")
                .build();
        UserDetails admin = User
                .withDefaultPasswordEncoder()
                .username("admin")
                .password("admin@123")
                .roles("ADMIN")
                .build();

        return new InMemoryUserDetailsManager(user, admin);
    }
*/
}
