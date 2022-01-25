//package com.harman.security;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.core.annotation.Order;
//import org.springframework.http.HttpMethod;
//import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
//
//@Configuration
//@Order(2)
//public class SecurityConfigUser extends WebSecurityConfigurerAdapter {
//	@Override
//	protected void configure(HttpSecurity http) throws Exception {
//		
//		http.authorizeRequests()
//		.antMatchers("/**").authenticated()
//		.anyRequest().permitAll()
//		.and()
//		.csrf().disable();
//		
////		http.csrf().disable().
////
////				authorizeRequests()
////				.antMatchers(HttpMethod.OPTIONS, "/**").permitAll().anyRequest().authenticated()
////				.and().httpBasic();
////				.antMatchers("/admin").hasRole("ADMIN")
////                .antMatchers("/user").hasAnyRole("ADMIN", "USER")
////                .antMatchers("/").permitAll().and().httpBasic();
//	}
//
//	@Autowired
//	public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
//		auth.inMemoryAuthentication().withUser("user1").password("{noop}pass").roles("USER");
//		
//	}
//}