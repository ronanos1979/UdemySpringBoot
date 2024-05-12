package com.ronanos.spring.introToSpringFramework.game;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
@Primary
public class PacmanGame implements GamingConsole {

	@Override
	public void up() {
		System.out.println("Pacman Up");
	}

	@Override
	public void down() {
		System.out.println("Pacman Down");		
	}

	@Override
	public void left() {
		System.out.println("Pacman Left");		
	}

	@Override
	public void right() {
		System.out.println("Pacman Right");		
	}

}
