package com.library.config;

//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
//import org.springframework.security.crypto.password.PasswordEncoder;
//
//@EnableWebSecurity
//@Configuration
//public class AuthConfiguration extends WebSecurityConfigurerAdapter {
//
//	public void configure(AuthenticationManagerBuilder auth) throws Exception {
//		
//		String pass = passwordEncoder().encode("Password123");
//		auth.inMemoryAuthentication().withUser("rdas").password(pass).roles("Admin")
//			.and()
//			.withUser("sghosh").password(pass).roles("Librarian");
//	}
//	
//	public void configure(HttpSecurity http) throws Exception {
//		http.authorizeRequests()
//			.antMatchers("/librarian/**").hasRole("Admin")
//			.antMatchers("/book/**").hasRole("Librarian")
//			.and().httpBasic();
//			
//			http.headers().frameOptions().disable();
//			http.csrf().ignoringAntMatchers("/h2-console/**");
//			
//	}
//	
//	@Bean
//	public PasswordEncoder passwordEncoder() {
//		return new BCryptPasswordEncoder();
//	}
//	
//}
