package com.itstech.dharm.springsecuritydemo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.annotation.web.configurers.AuthorizeHttpRequestsConfigurer;
import org.springframework.security.config.annotation.web.configurers.CsrfConfigurer;
import org.springframework.security.config.annotation.web.configurers.SessionManagementConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) {
/*

        // THIS IMPERATIVE STYLE
        */
/*  FOR csrf *//*

        Customizer<CsrfConfigurer<HttpSecurity>> csrfCustomizer =
                new Customizer<CsrfConfigurer<HttpSecurity>>() {
            @Override
            public void customize(CsrfConfigurer<HttpSecurity> httpSecurityCsrfConfigurer) {
                httpSecurityCsrfConfigurer.disable();
            }
        };
        http.csrf(csrfCustomizer);

        */
/*  FOR AuthorizeHttpRequests *//*

        Customizer<AuthorizeHttpRequestsConfigurer<HttpSecurity>.AuthorizationManagerRequestMatcherRegistry> auth =
                new Customizer<AuthorizeHttpRequestsConfigurer<HttpSecurity>.AuthorizationManagerRequestMatcherRegistry>() {
                    @Override
                    public void customize(AuthorizeHttpRequestsConfigurer<HttpSecurity>.AuthorizationManagerRequestMatcherRegistry authorization) {
                        authorization.anyRequest().authenticated();
                    }
                };
        http.authorizeHttpRequests(auth);

        */
/*  FOR AuthorizeHttpRequests *//*

        Customizer<SessionManagementConfigurer<HttpSecurity>> session =
                new Customizer<SessionManagementConfigurer<HttpSecurity>>() {
            @Override
            public void customize(SessionManagementConfigurer<HttpSecurity> sessionManagement) {
                sessionManagement.sessionCreationPolicy(SessionCreationPolicy.STATELESS);
            }
        };
        http.sessionManagement(session);

        return http.build();
*/

        // THIS DECLARATIVE STYLE
       http
                .csrf(
                        AbstractHttpConfigurer::disable)
                .authorizeHttpRequests(
                        auth -> auth.anyRequest().authenticated())
                //.formLogin(Customizer.withDefaults()) // NO NEED TO USED FOR STATELESS SESSION
                .httpBasic(Customizer.withDefaults())
                .sessionManagement(
                        session ->
                                session.sessionCreationPolicy(SessionCreationPolicy.STATELESS));
        return http.build();
    }
}
