package com.ronanos.spring.introToSpringFramework.game;

import org.springframework.stereotype.Component;

@Component
public class MarioGame implements GamingConsole {
	
	public void up () {
		System.out.println("jump");
	}

	public void down () {
		System.out.println("down into hole");
	}
	
	public void left () {
		System.out.println("stop");
	}
	
	public void right () {
		System.out.println("accelerate");
	}
}
