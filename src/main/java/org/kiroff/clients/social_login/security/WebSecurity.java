package org.kiroff.clients.social_login.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class WebSecurity
{
    @Bean
    SecurityFilterChain configure(HttpSecurity http) throws Exception
    {
        http.authorizeHttpRequests(a -> a
                .requestMatchers(HttpMethod.GET, "/").permitAll()
                .anyRequest().authenticated()
            )
            .oauth2Login(o -> o.defaultSuccessUrl("/home", true))
            .logout(l -> l.logoutSuccessUrl("/"));

        return http.build();
    }
}
