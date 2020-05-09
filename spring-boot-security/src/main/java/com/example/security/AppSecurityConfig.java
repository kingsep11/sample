package com.example.security;

import java.security.AuthProvider;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.provisioning.UserDetailsManager;

@Configuration
@EnableWebSecurity
public class AppSecurityConfig extends WebSecurityConfigurerAdapter{
	
	@Autowired
	UserDetailsService userDetailsService;

	/**
	 * Authorizatio **/
	/** @Override
	protected void configure(HttpSecurity http) throws Exception {
		http
			.authorizeRequests()
				.antMatchers("/", "/login").permitAll()
				.anyRequest().authenticated()
				.and()
			.formLogin()
				.loginPage("/login")
				.permitAll()
				.and()
			.logout()
				.permitAll();
	}**/
	
	/**@Bean
	@Override
	protected UserDetailsService userDetailsService() {
		List userLst = new ArrayList<>();
		userLst.add(User.withDefaultPasswordEncoder().username("megan").password("mychellam").roles("all").build());
		return new InMemoryUserDetailsManager(userLst);
	}**/
	
	
	@Bean
	public AuthenticationProvider authProvider() {
		
		DaoAuthenticationProvider authProvide = new DaoAuthenticationProvider();
		authProvide.setUserDetailsService(userDetailsService);
		authProvide.setPasswordEncoder(NoOpPasswordEncoder.getInstance());
		//authProvide.setPasswordEncoder(new BCryptPasswordEncoder());
		return authProvide;
	}
}
 