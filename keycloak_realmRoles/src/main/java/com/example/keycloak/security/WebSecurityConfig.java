package com.example.keycloak.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.oauth2.server.resource.authentication.JwtAuthenticationConverter;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig {

  public static final String ADMIN = "ROLE_app_admin";
  public static final String USER = "ROLE_app_user";

  @Bean
  public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
    JwtAuthenticationConverter jwtAuthConverter = new JwtAuthenticationConverter();
    jwtAuthConverter.setJwtGrantedAuthoritiesConverter(new JwtAuthConverter());
    http.authorizeHttpRequests()
        .requestMatchers(HttpMethod.GET, "/test/anonymous", "/test/anonymous/**").permitAll()
        .requestMatchers(HttpMethod.GET, "/test/admin", "/test/admin/**").hasAuthority(ADMIN)
        .requestMatchers(HttpMethod.GET, "/test/user", "/test/user/**").hasAuthority(USER)
        .anyRequest().authenticated();
    http.oauth2ResourceServer()
        .jwt()
        .jwtAuthenticationConverter(jwtAuthConverter);
    http.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
    return http.build();
  }

}