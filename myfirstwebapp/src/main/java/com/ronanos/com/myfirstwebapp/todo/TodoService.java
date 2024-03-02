package com.ronanos.com.myfirstwebapp.todo;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jakarta.validation.Valid;

@Service
public class TodoService {
	@Autowired
	private static List<Todo> todos = new ArrayList<>();
	
	private static int todosCount = 0;
	
	static {
		todos.add(new Todo(++todosCount, "John", "Learn AWS", 
				LocalDate.now().plusYears(1), false));
		todos.add(new Todo(++todosCount, "Ronan", "Learn Devops", 
				LocalDate.now().plusYears(2), false));
		todos.add(new Todo(++todosCount, "Ronan", "Learn Full Stack Development", 
				LocalDate.now().plusYears(3), false));
	}
	
	public List<Todo> findByUserName(String username) {
		Predicate<? super Todo> predicate 
			= todo -> todo.getUsername().equalsIgnoreCase(username);					
		return todos.stream().filter(predicate).toList();
	}
	
	public void addTodo(String name, String description, LocalDate targetDate, boolean isDone) {		
		Todo todo = new Todo(++todosCount, name, description, targetDate, isDone);		
		todos.add(todo);		
	}
	
	public void deleteById(int id) {
		Predicate<? super Todo> predicate 
			= todo -> todo.getId() == id;
		todos.removeIf(predicate);
	}	

	public Todo findById(int id) {
		Predicate<? super Todo> predicate 
		= todo -> todo.getId() == id;
		Todo todo = todos.stream().filter(predicate).findFirst().get();
		return todo;
	}

	public void updateTodo(@Valid Todo todo) {
		deleteById(todo.getId());
		todos.add(todo);
	}

}
