package com.ronanos.com.myfirstwebapp.security;

import java.util.function.Function;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

@Configuration
public class SpringSecurityConfiguration {


// Commented out for more secure password encoding below
//	@Bean
//	public InMemoryUserDetailsManager createUserDetailsManager() {
//		UserDetails userDetails = User.withDefaultPasswordEncoder()
//			.username("ronan")
//			.password("password")
//			.roles("USER","ADMIN")
//			.build();
//		return new InMemoryUserDetailsManager(userDetails);
//	}
	
	@Bean
	public InMemoryUserDetailsManager createUserDetailsManager() {
		UserDetails userDetails1 = createNewUser("ronan", "password");
		UserDetails userDetails2 = createNewUser("ronan2", "password");
		return new InMemoryUserDetailsManager(userDetails1, userDetails2);
	}

private UserDetails createNewUser(String username, String password) {
	Function<String, String> encoder = 
			input -> passwordEncoder().encode(input);
			
	UserDetails userDetails = User.builder()
		.passwordEncoder(encoder)
		.username(username)
		.password(password)
		.roles("USER","ADMIN")
		.build();
	return userDetails;
}
	
	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}



}
