package com.dmac.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
public class SpringSecurityConfigurator extends WebSecurityConfigurerAdapter {

	@Autowired
	public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
		auth.inMemoryAuthentication().withUser("mkyong").password("123456").roles("USER");
		auth.inMemoryAuthentication().withUser("admin").password("123456").roles("ADMIN");
		auth.inMemoryAuthentication().withUser("dba").password("123456").roles("DBA");
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {

		/*
		http
	    .authorizeRequests()
	        .antMatchers("/loginUser/").permitAll()
	        .antMatchers("/inferneon/**").hasAuthority("admin")
	        .anyRequest().authenticated()
	        .and().formLogin().loginPage("/loginUser/login.html").permitAll()
	        .and().logout().logoutSuccessUrl("/loginUser/login.html?logout").permitAll();
		
		/*
		http.authorizeRequests()
				.antMatchers("/**")
				.hasRole("USER")
				.antMatchers("/loginUser/login.html")
				.anonymous().and().httpBasic()				
				.and().formLogin()
				.loginPage("/loginUser/login.html").failureUrl("/loginUser/login.html?failure")
				.usernameParameter("username")
				.passwordParameter("password")
				.and().logout().logoutSuccessUrl("/loginUser/login.html?logout")
				.and().csrf()
				.and().exceptionHandling().accessDeniedPage("/403"); */
		
	}
}