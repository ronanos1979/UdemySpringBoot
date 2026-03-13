package com.ronanos.springboot.firstrestapi.survey;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Base64;

import org.json.JSONException;
import org.junit.jupiter.api.Test;
import org.skyscreamer.jsonassert.JSONAssert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
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

	@Autowired
	private TestRestTemplate template;

	// http://localhost:8080/surveys/Survey1/questions/Question1
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
	private static String GENERIC_QUESTIONS_URL = "/surveys/Survey1/questions";

	// Authorization
	// Basic 
	
	@Test
	void retrieveSpecificSurveyQuestion_basicScenario() throws JSONException {
		// Initially used this but then commented out as we added security in headers with authorization
		// ResponseEntity<String> responseEntity = template.getForEntity(SPECIFIC_QUESTION_URL, String.class);
		
		HttpHeaders headers = createHttpContentTypeAndAuthorizationHeaders();
		
		HttpEntity<String> httpEntity = new HttpEntity(null, headers);
		
		ResponseEntity<String> responseEntity 
			= template.exchange(SPECIFIC_QUESTION_URL, HttpMethod.GET, httpEntity, String.class);
		

		String expectedResponse = """

				{
				  "id": "Question1",
				  "description": "Most Popular Cloud Platform Today",
				  "correctAnswer": "AWS"
				}

					""";

		// Status of response is 200
		assertTrue(responseEntity.getStatusCode().is2xxSuccessful());

		// [Content-Type:"application/json"
		// Always put expected first
		assertEquals("application/json", responseEntity.getHeaders().get("Content-Type").get(0));

		// Check the actual content
		JSONAssert.assertEquals(expectedResponse, responseEntity.getBody(), false);

		// Original one which was no use
		// assertEquals(expectedResponse.trim(), responseEntity.getBody());
//		System.out.println(responseEntity.getBody());
//		System.out.println(responseEntity.getHeaders());

	}

	@Test
	void retrieveAllSurveyQuestions_basicScenario() throws JSONException {
		// Initially used this but then commented out as we added security in headers with authorization
		// ResponseEntity<String> responseEntity = template.getForEntity(GENERIC_QUESTIONS_URL, String.class);
				
		HttpHeaders headers = createHttpContentTypeAndAuthorizationHeaders();
		
		HttpEntity<String> httpEntity = new HttpEntity(null, headers);
		
		ResponseEntity<String> responseEntity 
			= template.exchange(GENERIC_QUESTIONS_URL, HttpMethod.GET, httpEntity, String.class);

		String expectedResponse = """

				[
				  {
				    "id": "Question1"
				  },
				  {
				    "id": "Question2"
				  },
				  {
				    "id": "Question3"
				  }
				]

								""";

		// Status of response is 200
		assertTrue(responseEntity.getStatusCode().is2xxSuccessful());

		// [Content-Type:"application/json"
		// Always put expected first
		assertEquals("application/json", responseEntity.getHeaders().get("Content-Type").get(0));

		// Check the actual content
		JSONAssert.assertEquals(expectedResponse, responseEntity.getBody(), false);

	}

	@Test
	void addNewSurveyQuestion_basicScenario() throws JSONException {
		String requestBody = """
				{
				  "description": "Your Favorite Language",
				  "options": [
				    "Java",
				    "Python",
				    "JavaScript",
				    "C++"
				  ],
				  "correctAnswer": "C++"
				}
								
												""";
		
		HttpHeaders headers = createHttpContentTypeAndAuthorizationHeaders();
			
		HttpEntity<String> httpEntity = new HttpEntity(requestBody, headers);
		
		ResponseEntity<String> responseEntity 
			= template.exchange(GENERIC_QUESTIONS_URL, HttpMethod.POST, httpEntity, String.class);
		
		System.out.println(responseEntity.getHeaders());
		System.out.println(responseEntity.getBody());
				
		// Status of response is 200
		assertTrue(responseEntity.getStatusCode().is2xxSuccessful());
		// Location: 	http://localhost:8080/surveys/Survey1/questions/3978423152
		String locationHeader = responseEntity.getHeaders().get("Location").get(0);
		assertTrue(locationHeader.contains("/surveys/Survey1/questions/"));
		
		// DELETE
		//
		// Initially used this but then commented out as we added security in headers with authorization
		template.delete(locationHeader);
		
		ResponseEntity<String> responseEntityDelete
		= template.exchange(locationHeader, HttpMethod.DELETE, httpEntity, String.class);		
				
	}

	private HttpHeaders createHttpContentTypeAndAuthorizationHeaders() {
		HttpHeaders headers = new HttpHeaders();
		headers.add("Content-Type", "application/json");
		// This value was got from talend chrome plugin when adding user credentials and it was created.	
		// Logic is in performBasicAuthEncoding.
		// headers.add("Authorization", "Basic cm9uYW46cGFzc3dvcmQ=");  
		headers.add("Authorization", "Basic " + performBasicAuthEncoding("ronan", "password"));
		return headers;
	}

	String performBasicAuthEncoding(String user, String password) {
		String combined = user + ":" + password;
		// Base64 Encoding => Bytes		
		byte[] encodedBytes = Base64.getEncoder().encode(combined.getBytes());
		// Bytes => String
		
		return new String(encodedBytes);		
	}
	
}