package com.inci.Page.by.Page.Book.Store.security.config;

import com.inci.Page.by.Page.Book.Store.repositories.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@RequiredArgsConstructor
public class ApplicationConfig {

    private final UserRepository userRepository;
    @Bean
    //  Retrieves a user by email from the UserRepository and converts it into a UserDetails object
    public UserDetailsService userDetailsService() {
        return username -> userRepository.findByEmail(username)
                .orElseThrow (()-> new UsernameNotFoundException("User not found!"));
    }

    @Bean
    //  PasswordEncoder interface of Spring Security: responsible for encoding and verifying passwords
    //  BCryptPasswordEncoder: BCrypt hashing algorithm to securely hash passwords
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    //  AuthenticationProvider interface of Spring Security: responsible for a specific type of authentication
    //  DaoAuthenticationProvider : implementation of AuthenticationProvider that retrieves user details from a
    //                              UserDetailsService and uses a PasswordEncoder to validate passwords.
    public AuthenticationProvider authenticationProvider(){
        DaoAuthenticationProvider authProvider = new DaoAuthenticationProvider();
        authProvider.setUserDetailsService(userDetailsService());
        authProvider.setPasswordEncoder(passwordEncoder());
        return authProvider;
    }

    @Bean
    //  AuthenticationManager interface of Spring Security: responsible for authenticating users
    //  AuthenticationConfiguration of Spring Framework: implementation of this method depends on the specific
    //                                                   configuration set up in the application.
    public AuthenticationManager authenticationManager(AuthenticationConfiguration authenticationConfiguration)
            throws Exception{
        return authenticationConfiguration.getAuthenticationManager();
    }

}
