package com.almo.restaurant.config;

import com.almo.restaurant.enums.PersonRole;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

import static org.springframework.security.config.Customizer.withDefaults;

@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
public class SecurityConfig {
private final PersonDetailService userDetailService;
    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http.authorizeHttpRequests(authRequests ->
                        authRequests
                                .requestMatchers("/admin/**").hasRole(PersonRole.ADMIN.name())
                                .requestMatchers("/user/**").hasRole(PersonRole.USER.name())
                                .requestMatchers("guests/**").hasRole(PersonRole.GUEST.name())
                                .requestMatchers("/css/**","/js/**","/register","/home","login","/activate","/reset-password").permitAll()
                                .anyRequest().authenticated()
                )
                .formLogin(formLogin ->
                        formLogin
                            .loginPage("/login")
                            .defaultSuccessUrl("/register", true)
                            .permitAll()
                )
                .logout(logout ->
                        logout
                                .logoutUrl("/logout")
                                .permitAll()
                );

        return http.build();
    }
    @Bean
    public UserDetailsService userDetailsService(){
        return userDetailService;
    }
   // @Autowired
    public void configureGlobale(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailService);
    }
    @Bean
    public PasswordEncoder passwordEncoder() {

        return new BCryptPasswordEncoder();
    }
}
