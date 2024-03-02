package com.ronanos.springboot.learnjpaandhibernate.course;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.ronanos.springboot.learnjpaandhibernate.course.jdbc.CourseJDBCRepository;
import com.ronanos.springboot.learnjpaandhibernate.course.jpa.CourseJPARepository;
import com.ronanos.springboot.learnjpaandhibernate.course.springdatajpa.CourseSpringDataJpaRepository;

@Component
public class CourseCommandLineRunner implements CommandLineRunner {

//	@Autowired
//	private CourseJDBCRepository repository;

//	@Autowired
//	private CourseJPARepository repository;

	@Autowired
	private CourseSpringDataJpaRepository repository;
	
	@Override
	public void run(String... args) throws Exception {
//		repository.insert(new Course(1, "Learn AWS", "ronan"));
//		repository.insert(new Course(2, "Learn Spring Boot", "ronan"));
//		repository.insert(new Course(3, "Learn Azure", "ronan"));
//		repository.deleteById(1);
//
//		System.out.println(repository.findById(2));
//		System.out.println(repository.findById(3));
		repository.save(new Course(1, "Learn AWS", "ronan"));
		repository.save(new Course(2, "Learn Spring Boot", "ronan"));
		repository.save(new Course(3, "Learn Azure", "ronan"));
		repository.deleteById(1l);

		System.out.println(repository.findById(2l));
		System.out.println(repository.findById(3l));
		
		System.out.println(repository.findAll());
		System.out.println(repository.count());
				
		System.out.println("Find by Author" + repository.findByAuthor("ronan"));
		
		System.out.println("Find by course Name: " + repository.findByName("Learn Azure"));
	}

}
