package com.ronanos.springboot.firstrestapi.survey;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.json.JSONException;
import org.junit.jupiter.api.Test;
import org.skyscreamer.jsonassert.JSONAssert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.http.ResponseEntity;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public class SurveyResourceIT {
	
	// Ronan changed this.
	// Added this for support for Spring Boot 4.
	// Alternate would be to use WebTestClient
//	@TestConfiguration
//	static class TestConfig {
//	    @Bean
//	    TestRestTemplate testRestTemplate() {
//	        return new TestRestTemplate();
//	    }
//	}
	
	//http://localhost:8080/surveys/Survey1/questions/Question1
	String str = """			
			{
			  "id": "Question1",
			  "description": "Most Popular Cloud Platform Today",
			  "options": [
			    "AWS",
			    "Azure",
			    "Google Cloud",
			    "Oracle Cloud"
			  ],
			  "correctAnswer": "AWS"
			}			
			""";
	
	private static String SPECIFIC_QUESTION_URL = "/surveys/Survey1/questions/Question1";
	
	@Autowired
	private TestRestTemplate template;
	
	//
	//[Content-Type:"application/json", 
	
	@Test
	void retrieveSpecificSurveyQuestion_basicScenario() throws JSONException {
		ResponseEntity<String> responseEntity = template.getForEntity(SPECIFIC_QUESTION_URL, String.class);
		System.out.println("------------------------------------------------------------");
		System.out.println(responseEntity.getBody());
		System.out.println(responseEntity.getHeaders());
		
		String expectedResponse =
				"""
				
			{
			  "id": "Question1",
			  "description": "Most Popular Cloud Platform Today",
			  "correctAnswer": "AWS"
			}	
			
				""";

		System.out.println("responseEntity.getBody is:" + responseEntity.getBody());
		System.out.println("expectedResponse is:" + expectedResponse);
		JSONAssert.assertEquals(expectedResponse, responseEntity.getBody(), false);
//		assertEquals(expectedResponse.trim(), responseEntity.getBody());
		System.out.println(responseEntity.getBody());
		System.out.println(responseEntity.getHeaders());
	}
	
	
}