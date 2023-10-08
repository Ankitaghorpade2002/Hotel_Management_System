package com.guest.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfiguration;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.guest.security.JwtAuthenticationFilter;
import com.guest.service.GuestdetailsService;

@Configuration
@EnableWebSecurity
@EnableMethodSecurity(prePostEnabled = true)
public class Config {
	
	

	@Autowired
	private JwtAuthenticationFilter filter;
	
	
	@Bean
	public UserDetailsService userDetailsService() {
		return new GuestdetailsService();
	}
	
	
	@Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        
		return http.csrf().disable()
	            .authorizeRequests()
	            .requestMatchers(request -> {
	                String servletPath = request.getServletPath();
	                return "/guest/addUser".equals(servletPath)
	                        || "/guest/login".equals(servletPath);
	            }).permitAll()
	            .requestMatchers(request -> {
	                String servletPath = request.getServletPath();
	                return "/guest/getallusers".equals(servletPath)
	                        || request.getContextPath().matches("/guest/viewByEmailId/.*")
	                        || request.getContextPath().matches("/guest/deleteUser/.*")
	                        || request.getContextPath().matches("/guest/role/.*");
	            }).authenticated()
	            .requestMatchers("/guest/getallusers").hasAuthority("ADMIN")
	            .and()
	            .sessionManagement()
	            .sessionCreationPolicy(SessionCreationPolicy.STATELESS)
	            .and()
	            .authenticationProvider(authenticationProvider())
	            .addFilterBefore(filter, UsernamePasswordAuthenticationFilter.class)
	            .build();
    }
	
	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
	        
	@Bean
	public AuthenticationProvider authenticationProvider() {
		DaoAuthenticationProvider authenticationProvider = new DaoAuthenticationProvider();
		authenticationProvider.setUserDetailsService(userDetailsService());
		authenticationProvider.setPasswordEncoder(passwordEncoder());
		return authenticationProvider;
	}
	
	@Bean
	public AuthenticationManager authenticationManager(AuthenticationConfiguration config) throws Exception {
		return config.getAuthenticationManager();
	}
	
}
