package com.emp;

import static org.hamcrest.CoreMatchers.containsString;
import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.springframework.test.web.client.match.MockRestRequestMatchers.content;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;

import java.io.IOException;

import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.ResultMatcher;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import com.emp.controller.EmployeeCrudController;
import com.emp.model.JwtRequest;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@SpringBootTest
@WebAppConfiguration
public class EmployeeControllerTest {
	
	//@Autowired
	private MockMvc mvc;
	
	 private MockMvc mockMvc;
	
	   @Autowired
	   WebApplicationContext webApplicationContext;

	   @Before
	   protected void setUp() {
	      mvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
	   }
	   protected String mapToJson(Object obj) throws JsonProcessingException {
	      ObjectMapper objectMapper = new ObjectMapper();
	      return objectMapper.writeValueAsString(obj);
	   }
	   protected <T> T mapFromJson(String json, Class<T> clazz)
	      throws JsonParseException, JsonMappingException, IOException {
	      
	      ObjectMapper objectMapper = new ObjectMapper();
	      return objectMapper.readValue(json, clazz);
	   }
	
	@Test
	public void getAuthenticationToken() throws Exception {
		  String uri = "/authenticate";
		  mvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
		  ObjectMapper Obj = new ObjectMapper();
		  JwtRequest request = new JwtRequest();
		   request.setPassword("password");
		   request.setUsername("admin");
		   
		   String inputJson = Obj.writeValueAsString(request);
		   MvcResult mvcResult = mvc.perform(post(uri)
		      .contentType(MediaType.APPLICATION_JSON_VALUE).content(inputJson)).andReturn();
		   
		   int status = mvcResult.getResponse().getStatus();
		   assertEquals(200, status);
		   String content = mvcResult.getResponse().getContentAsString();
		   assertNotEquals(content, null);
		
	}
	
	@Test
	public void getGreeting() throws Exception {
		  String uri = "/greeting";
		  mvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
		   RequestBuilder requestBuilder = MockMvcRequestBuilders.get(
					uri).accept(
					MediaType.APPLICATION_JSON)
				   .header("Authorization", "Bearer eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJhZG1pbiIsImV4cCI6MTYzMTM3ODIxMiwiaWF0IjoxNjMxMzYwMjEyfQ.ORxGT7lH97EA2-ET3-Y52iSZ-lRWNrwTs1MnrRfrKHKmxFfx3rY7PzsLW_019WpiREgqEE1tDBtrDJqMbbgXtg");

			MvcResult result = mvc.perform(requestBuilder).andReturn();
			assertEquals("Welcome!", result.getResponse().getContentAsString());
			//System.out.println(result.getResponse().getContentAsString());
		
	}

}
