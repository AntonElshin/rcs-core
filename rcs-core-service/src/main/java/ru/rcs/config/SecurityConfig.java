package ru.rcs.config;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@RequiredArgsConstructor
@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Value("${security.enabled}")
    private boolean securityEnabled;

    @Override
    public void configure(HttpSecurity http) throws Exception {
        if (securityEnabled) {
            http
                    .csrf().disable()
                    .authorizeRequests()
                    .antMatchers("/v2/api-docs", "/swagger-resources/configuration/ui", "/configuration/ui", "/swagger-resources", "/swagger-resources/configuration/security", "/configuration/security", "/swagger-ui.html").permitAll()
                    .anyRequest().authenticated()
                    .and()
                    .formLogin().permitAll()
                    .and()
                    .logout().logoutRequestMatcher(new AntPathRequestMatcher("/logout")).permitAll();
        }
        else {
            http
                    .csrf().disable()
                    .authorizeRequests().antMatchers("/**").permitAll();
        }
    }



}
