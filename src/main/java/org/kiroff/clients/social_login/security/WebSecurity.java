package org.kiroff.clients.social_login.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.oauth2.client.oidc.web.logout.OidcClientInitiatedLogoutSuccessHandler;
import org.springframework.security.oauth2.client.registration.ClientRegistrationRepository;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class WebSecurity
{

    @Autowired
    ClientRegistrationRepository clientRegistrationRepository;

    @Bean
    SecurityFilterChain configure(HttpSecurity http) throws Exception
    {
        http.authorizeHttpRequests(a -> a
                .requestMatchers(HttpMethod.GET, "/").permitAll()
                .anyRequest().authenticated()
            )
            .oauth2Login(o -> o.defaultSuccessUrl("/home", true))
            .logout(l ->
                    //l.logoutSuccessUrl("/")
                    l.logoutSuccessHandler(oidcLogoutSuccessHandler())
                    .invalidateHttpSession(true)
                    .clearAuthentication(true)
                    .deleteCookies("JSESSIONID"));

        return http.build();
    }

    private OidcClientInitiatedLogoutSuccessHandler oidcLogoutSuccessHandler()
    {
        final OidcClientInitiatedLogoutSuccessHandler oidcClientInitiatedLogoutSuccessHandler = new OidcClientInitiatedLogoutSuccessHandler(clientRegistrationRepository);
        oidcClientInitiatedLogoutSuccessHandler.setPostLogoutRedirectUri("{baseUrl}/xyu");//Not working (yet)
        return oidcClientInitiatedLogoutSuccessHandler;
    }
}
