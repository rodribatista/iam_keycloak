package com.example.keycloak.security;

import org.springframework.core.convert.converter.Converter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.stereotype.Component;

import java.util.*;
import java.util.stream.Collectors;

@Component
public class JwtAuthConverter implements Converter<Jwt, Collection<GrantedAuthority>> {

  public Collection<GrantedAuthority> convert(Jwt source) {
    Collection<GrantedAuthority> authorities = new ArrayList<>();
    Map<String, Object> realmAccessRoles = source.getClaim("realm_access");
    if (realmAccessRoles != null && !realmAccessRoles.isEmpty()) {
      authorities.addAll(extractRoles(realmAccessRoles));
    }
    return authorities;
  }

  private static Collection<GrantedAuthority> extractRoles(Map<String, Object> realmAccessRoles) {
    return ((List<String>) realmAccessRoles.get("roles"))
        .stream().map(role -> "ROLE_" + role)
        .map(SimpleGrantedAuthority::new)
        .collect(Collectors.toList());
  }

}