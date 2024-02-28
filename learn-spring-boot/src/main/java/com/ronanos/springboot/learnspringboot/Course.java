package com.ronanos.springboot.learnspringboot;

public class Course {
	private long Id;
	private String name;
	private String author;
	
	public Course(long id, String name, String author) {
		super();
		Id = id;
		this.name = name;
		this.author = author;
	}

	public long getId() {
		return Id;
	}
	
	public String getName() {
		return name;
	}
	
	public String getAuthor() {
		return author;
	}
	
	@Override
	public String toString() {
		return "Course [Id=" + Id + ", name=" + name + ", author=" + author + "]";
	}	
}
