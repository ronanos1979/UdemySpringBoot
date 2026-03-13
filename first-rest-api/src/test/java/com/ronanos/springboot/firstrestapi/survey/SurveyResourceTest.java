package com.ronanos.springboot.firstrestapi.survey;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;

import java.util.Arrays;

import org.junit.jupiter.api.Test;
import org.skyscreamer.jsonassert.JSONAssert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;


@WebMvcTest(controllers = SurveyResource.class)
@AutoConfigureMockMvc(addFilters = false) // This disables security for tests

class SurveyResourceTest {

	@MockBean
	private SurveyService surveyService;
	
	@Autowired
	private MockMvc mockMvc;
	
	// Mock -> surveyService.retrieveSpecificSurveyQuestion(surveyId,questionId); 
	// Fire a request
	// http://localhost:8080/surveys/Survey1/questions/Question1 GET
	private static String SPECIFIC_QUESTION_URL = "http://localhost:8080/surveys/Survey1/questions/Question1";
	private static String GENERIC_QUESTIONS_URL = "http://localhost:8080/surveys/Survey1/questions";

	
	@Test
	void retrieveSpecificSurveyQuestion_404Scenario() throws Exception {
		RequestBuilder requestBuilder = MockMvcRequestBuilders.get(SPECIFIC_QUESTION_URL).accept(MediaType.APPLICATION_JSON);
		MvcResult mvcResult = mockMvc.perform(requestBuilder).andReturn();
		
		System.out.println(mvcResult.getResponse().getContentAsString());
		System.out.println(mvcResult.getResponse().getStatus());
		
		assertEquals(404, mvcResult.getResponse().getStatus());

	}
	
	@Test
	void retrieveSpecificSurveyQuestion_basicScenario() throws Exception {
		RequestBuilder requestBuilder = 
				MockMvcRequestBuilders.get(SPECIFIC_QUESTION_URL).accept(MediaType.APPLICATION_JSON);
				
		Question question = new Question("Question1",
		        "Most Popular Cloud Platform Today", Arrays.asList(
		                "AWS", "Azure", "Google Cloud", "Oracle Cloud"), "AWS");
		
		when(surveyService.retrieveSpecificSurveyQuestion("Survey1", "Question1")).thenReturn(question);
		
		MvcResult mvcResult = mockMvc.perform(requestBuilder).andReturn();
		
		String expectedResponse = """
				{"id":"Question1","description":"Most Popular Cloud Platform Today","options":["AWS","Azure","Google Cloud","Oracle Cloud"],"correctAnswer":"AWS"}
				""";
		
		MockHttpServletResponse mvcResponse = mvcResult.getResponse();
		System.out.println(mvcResponse.getContentAsString());
		System.out.println(mvcResponse.getStatus());
		
		assertEquals(200, mvcResponse.getStatus());
		JSONAssert.assertEquals(expectedResponse, mvcResponse.getContentAsString(), false);

	}
	
	// addNewSurveyQuestion
	// POST
	// http://localhost:8080/surveys/Survey1/questions
	// 	http://localhost:8080/surveys/Survey1/questions/3978423152
	
	@Test
	void addNewSurveyQuestion_basicScenario() throws Exception {
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
		
		when(surveyService.addNewSurveyQuestion(anyString(), any())).thenReturn("SOME_ID");
		
		
		RequestBuilder requestBuilder = 
				MockMvcRequestBuilders.post(GENERIC_QUESTIONS_URL)
				.accept(MediaType.APPLICATION_JSON)
				.content(requestBody).contentType(MediaType.APPLICATION_JSON);
		
		MvcResult mvcResult = mockMvc.perform(requestBuilder).andReturn();

		MockHttpServletResponse mvcResponse = mvcResult.getResponse();
		assertEquals(201, mvcResponse.getStatus());
		String locationHeader = mvcResponse.getHeader("Location");
		System.out.println(locationHeader + " was the Location");
		// JSONAssert.assertEquals(expectedResponse, mvcResult.getResponse().getContentAsString(), false);
		
		assertTrue(locationHeader.contains("/surveys/Survey1/questions/SOME_ID"));
				
	}
	

}
