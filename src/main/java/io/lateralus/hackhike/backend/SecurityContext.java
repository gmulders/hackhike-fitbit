package io.lateralus.hackhike.backend;

import com.google.api.client.auth.oauth2.AuthorizationCodeFlow;
import org.apache.http.HttpStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@EnableWebSecurity
public class SecurityContext extends WebSecurityConfigurerAdapter {

    @Autowired
    private AuthorizationCodeFlow authorizationCodeFlow;

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.exceptionHandling().authenticationEntryPoint((request, response, authException) -> response.setStatus(HttpStatus.SC_UNAUTHORIZED))
                .and()
                    .authorizeRequests()
                    .antMatchers("/login", "/login/rd", "/notifications").permitAll()
                    .anyRequest().authenticated()
                .and()
                    .csrf().disable()
                    .addFilterAfter(new OAuth2Filter(authorizationCodeFlow), UsernamePasswordAuthenticationFilter.class);
    }
}
