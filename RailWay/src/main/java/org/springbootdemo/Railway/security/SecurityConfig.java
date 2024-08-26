package org.springbootdemo.Railway.security;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

import javax.sql.DataSource;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http.csrf(csrf -> csrf.disable())
                .authorizeHttpRequests(authorize -> authorize.requestMatchers("/Railway/hello").permitAll()
                        .requestMatchers(HttpMethod.GET, "/Railway/Entries").hasRole("manager")
                        .requestMatchers(HttpMethod.POST, "/Railway/AddEntry", "/Railway/AddAllEntries").hasRole("employee")
                        .requestMatchers(HttpMethod.GET, "/Railway/RailwayEntryById/**").hasRole("admin")
                        .requestMatchers(HttpMethod.DELETE, "/Railway/delete/**").hasRole("manager")
                )

                .httpBasic(Customizer.withDefaults())
                .formLogin(Customizer.withDefaults());

        return http.build();
    }

    /*public SecurityConfig(DataSource dataSource){
        this.dataSource = dataSource;
    }*/
   /* public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception{
        http.csrf(Customizer.withDefaults())
                .authorizeHttpRequests(authorize ->authorize.requestMatchers("/Railway/hello").permitAll()
                        .requestMatchers(HttpMethod.GET,"/Railway/Entries").hasRole("manager")
                        .requestMatchers(HttpMethod.POST,"/Railway/AddEntry","/Railway/AddAllEntries").hasRole("employee")
                        .requestMatchers(HttpMethod.GET,"/Railway/RailwayEntryById/**").hasRole("admin")
                        .requestMatchers(HttpMethod.DELETE,"/Railway/delete/**").hasRole("manager")
                        .anyRequest().authenticated())

                        .httpBasic(Customizer.withDefaults())
                        .formLogin(Customizer.withDefaults());

        return http.build();
    }*/

    @Bean
    public UserDetailsService userDetailsService() {
        UserDetails ur = User.builder()
                .username("shub")
                .password("{noop}many")
                .roles("employee")
                .build();
        UserDetails uri = User.builder()
                .username("sanjay")
                .password("{noop}manny")
                .roles("admin")
                .build();
        UserDetails urri = User.builder()
                .username("urvashi")
                .password("{noop}maany")
                .roles("manager")
                .build();

        return new InMemoryUserDetailsManager(ur, uri, urri);
    }

    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }
}


