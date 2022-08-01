package com.robintegg.blend.web;

import org.springframework.boot.autoconfigure.security.servlet.PathRequest;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class WebSecurityConfiguration {

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
            .authorizeHttpRequests((authz) -> {
                authz.antMatchers("/add-link","/refresh-link-titles","/import-opml").authenticated();
                authz.antMatchers("/","/links").permitAll();
                authz.requestMatchers(PathRequest.toStaticResources().atCommonLocations()).permitAll();
                authz.anyRequest().denyAll();
            })
            .formLogin(Customizer.withDefaults())
            .logout((logout) -> logout.logoutSuccessUrl("/"));
        return http.build();
    }

}
