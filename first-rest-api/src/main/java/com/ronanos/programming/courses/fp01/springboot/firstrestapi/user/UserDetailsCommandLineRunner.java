package com.ronanos.programming.courses.fp01.springboot.firstrestapi.user;

import java.util.Arrays;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class UserDetailsCommandLineRunner implements CommandLineRunner{
	public UserDetailsCommandLineRunner(UserDetailsRepository repository) {
		super();
		this.repository = repository;
	}
	
	private Logger logger = LoggerFactory.getLogger(getClass());
	private UserDetailsRepository repository;
	

	@Override
	public void run(String... args) throws Exception {
		logger.info(Arrays.toString(args));		
		repository.save(new UserDetails("Ronan", "Admin"));
		repository.save(new UserDetails("Tilly", "Admin"));
		repository.save(new UserDetails("Michael", "User"));
		
		// To find all
		// List<UserDetails> users = repository.findAll();
		// To find by role
		List<UserDetails> users = repository.findByRole("Admin");
		
		users.forEach(user->logger.info(user.toString()));			
	}

}
