package com.ronanos.programming.courses.fp01.spring.introToSpringFramework;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import com.ronanos.programming.courses.fp01.spring.introToSpringFramework.enterprise.example.web.MyWebController;
import com.ronanos.programming.courses.fp01.spring.introToSpringFramework.game.GameRunner;


@SpringBootApplication
public class IntroToSpringFrameworkApplication {

	public static void main(String[] args) {
		ConfigurableApplicationContext context 
			= SpringApplication.run(IntroToSpringFrameworkApplication.class, args);
			
		// MarioGame game = new MarioGame();
		// SuperContraGame game = new SuperContraGame();
		//		PacmanGame game = new PacmanGame();
		// GamingConsole game = new MarioGame();<
		// GameRunner runner = new GameRunner(game);
		
		GameRunner runner = context.getBean(GameRunner.class);
		runner.run();
		
		MyWebController controller = context.getBean(MyWebController.class);
		System.out.println(controller.returnValueFromBusinessService());
	}

}
