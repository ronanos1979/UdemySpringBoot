package com.ronanos.springboot.learnjpaandhibernate.course.jdbc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.ronanos.springboot.learnjpaandhibernate.course.Course;

@Repository
public class CourseJDBCRepository {

	@Autowired
	private JdbcTemplate springJdbcTemplate;

//	private static String INSERT_QUERY = 
//			"""
//				Insert into COURSE(ID, NAME, AUTHOR) 
//				values (2,'Learn Everything','ronan');
//			""";
//	
	private static String INSERT_QUERY = """
				Insert into COURSE(ID, NAME, AUTHOR)
				values (?,?,?);
			""";

	private static String DELETE_QUERY = """
				delete from COURSE
				where ID = ?;
			""";

	private static String SELECT_QUERY = """
				select * from COURSE
				where ID = ?;
			""";

	public void insert(Course course) {
		springJdbcTemplate.update(INSERT_QUERY, course.getId(), course.getName(), course.getAuthor());
	}

	public void deleteById(long id) {
		springJdbcTemplate.update(DELETE_QUERY, id);
	}

	public Course findById(long id) {
		// Result Set => Bean => Row Mapper
		return springJdbcTemplate.queryForObject(SELECT_QUERY, new BeanPropertyRowMapper<>(Course.class), id);
	}

}
