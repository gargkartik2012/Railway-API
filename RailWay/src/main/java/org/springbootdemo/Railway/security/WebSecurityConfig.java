/*

package org.springbootdemo.Railway.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpStatus;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.annotation.web.configurers.LogoutConfigurer;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig {


    @Bean
    //authentication
    public UserDetailsService userDetailsService(PasswordEncoder encoder) {
        UserDetails admin = User.withUsername("kartik")
                .password(encoder.encode("asdc"))
                .roles("issue ticket")
                .build();

        return new InMemoryUserDetailsManager(admin);
    }

    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
       http
               .csrf(AbstractHttpConfigurer::disable)
               .authorizeHttpRequests(authorizeRequests -> authorizeRequests
                       .requestMatchers("/Railway/welcome").permitAll()
                       .anyRequest().authenticated()// All other requests need authentication
               )
               .formLogin(formLoginConfigurer -> formLoginConfigurer
                       .loginPage("/login") // Custom login page
                       .permitAll() // Allow everyone to see the login page
               )
               .logout(LogoutConfigurer::permitAll); // Allow everyone to access the logout functionality

        return http.build();
    }

    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }


}

*/
