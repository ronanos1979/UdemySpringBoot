package com.ronanos.com.myfirstwebapp.login;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

@Controller
@SessionAttributes("name")
public class LoginController {
	private Logger logger;	
	private AuthenticationService authenticationService;

	public LoginController(AuthenticationService authenticationService) {
		super();
		this.logger = LoggerFactory.getLogger(getClass());
		this.authenticationService = authenticationService;
	}

	@RequestMapping("oldlogin")
	public String gotoOldLoginPage(@RequestParam String name, ModelMap model) {
		model.put("name", name);
		// System.out.println("Request param is " + name );
		logger.debug("Request param is " + name );
		return "oldlogin";
	}
	
	@RequestMapping(value="login", method=RequestMethod.GET)
	public String gotoLoginPage() {
		return "login";
	}

	@RequestMapping(value="login", method=RequestMethod.POST)
	public String gotoWelcomePage(@RequestParam String name, @RequestParam String password, ModelMap model) {

		logger.debug("Handling login");
		
		if (authenticationService.authentication(name, password)) {
			model.put("name", name);
			//			model.put("password", password);			
			logger.info("User is logged in " + name);
			return "welcome";
		}
		
		model.put("errorMessage", "Invalid Credentials! Please try again");		
		logger.error("Login failed for user " + name);
		return "login";			
	}
	
	
}
