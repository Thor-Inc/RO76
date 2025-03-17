package com.usecase.shop.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;

@Configuration
public class SecurityConfiguration {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {

        http.securityMatcher("/**")
                .authorizeHttpRequests(authorize -> authorize
                        .anyRequest().authenticated())
                .formLogin(form -> form
                        .loginPage("/admin/login")  // Make sure the login page URL starts with "/"
                        .loginProcessingUrl("/perform_login")  // Endpoint to process login
                        .defaultSuccessUrl("/", true)  // Redirect to the home page after successful login
                        .failureUrl("/login?error")  // Redirect to this URL if login fails
                        .permitAll())
                .logout(form ->
                        form.logoutUrl("/perform_logout")
                        .logoutSuccessUrl("/admin/login")
                        .invalidateHttpSession(true)
                        .deleteCookies("JSESSIONID", "myCart"));

      /*  http.csrf().disable();

        http.authorizeHttpRequests((authz) -> authz
                        .requestMatchers("/admin/orderList", "/admin/order", "/admin/accountInfo")
                .hasAuthority("MANAGER")).csrf(AbstractHttpConfigurer::disable);

        http.authorizeHttpRequests((authz) -> authz
                .requestMatchers("/admin/product")
                .hasAuthority("MANAGER")).csrf(AbstractHttpConfigurer::disable);

        // Configuration for Login Form.
        http.formLogin(formLogin -> formLogin
                .loginPage("/admin/login")
                .loginProcessingUrl("/admin/login")
                .loginProcessingUrl("/j_spring_security_check") // Submit URL
                .loginPage("/admin/login")//
                .defaultSuccessUrl("/")//
                .failureUrl("/admin/login?error=true")//
                .usernameParameter("userName")//
                .passwordParameter("password")
                .permitAll());
*/
        return http.build();
    }

/*
    @Bean
    public UserDetailsService userDetailsService() {
        var uds = new InMemoryUserDetailsManager();

        var user1 = User.withUsername("test1")
                .password("123")
                .authorities("read")
                .build();

        uds.createUser(user1);
        return uds;
    }
*/

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

}
