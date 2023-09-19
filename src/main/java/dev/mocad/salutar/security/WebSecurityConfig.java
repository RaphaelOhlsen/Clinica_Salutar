package dev.mocad.salutar.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.annotation.web.configurers.HeadersConfigurer;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;


@Configuration
@EnableWebSecurity
public class WebSecurityConfig {

// Cpnfiguraćão desabilitando o h2 no arquivo application.properties
  @Bean
  public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {

    http
        .authorizeHttpRequests(authorize -> authorize
                .requestMatchers(HttpMethod.POST, "/usuarios").permitAll()
                .anyRequest().authenticated()
        )
        .csrf(AbstractHttpConfigurer::disable);

    http.addFilterBefore(new MyFilter(), UsernamePasswordAuthenticationFilter.class);

    return http.build();
  }

//  //Este codigo funciona deixando o h2 habilitado no arquivo application.properties, mas não libera a rota /usuarios
//  @Bean
//  public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
//    http
//            .authorizeHttpRequests(auth -> auth
//                    .requestMatchers(AntPathRequestMatcher.antMatcher("/h2-console/**")).permitAll()
//
//            )
//            .headers(AbstractHttpConfigurer::disable)
//            .csrf(csrf -> csrf
//                    .ignoringRequestMatchers(AntPathRequestMatcher.antMatcher("/h2-console/**")));
//    return http.build();
//  }
}
