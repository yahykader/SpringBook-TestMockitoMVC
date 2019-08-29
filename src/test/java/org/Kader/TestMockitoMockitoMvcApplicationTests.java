package org.Kader;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.Kader.model.Employe;
import org.Kader.model.Response;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import com.fasterxml.jackson.databind.ObjectMapper;

import junit.framework.Assert;

@SuppressWarnings("deprecation")
@RunWith(SpringRunner.class)
@SpringBootTest
public class TestMockitoMockitoMvcApplicationTests {

	private MockMvc mockMvc;
	
	@Autowired
	private WebApplicationContext context;
	
	private ObjectMapper om=new ObjectMapper();
	
	@Before
	private void setUp() {
		mockMvc=MockMvcBuilders.webAppContextSetup(context).build();
	}
	
	@Test
	public void addEmployeTest() throws Exception {
		Employe employe=new Employe();
		employe.setName("Yahyaoui");
		employe.setDept("IT/Imformatique");
		String jsonRequest=om.writeValueAsString(employe);
		
		MvcResult result=mockMvc.perform(post("/employe/addEmploye").content(jsonRequest)
														   .content(MediaType.APPLICATION_JSON_VALUE))
														   .andExpect(status().isOk()).andReturn();
		String resultContent=result.getResponse().getContentAsString();
		Response reponse=om.readValue(resultContent, Response.class);
		Assert.assertTrue(reponse.isSuccess()==Boolean.TRUE);
	}
	
	@Test
	public void getEmployeTest() throws Exception {

		MvcResult result=mockMvc.perform(post("/employe/addEmploye")
														   .content(MediaType.APPLICATION_JSON_VALUE))
														   .andExpect(status().isOk()).andReturn();
		String resultContent=result.getResponse().getContentAsString();
		Response reponse=om.readValue(resultContent, Response.class);
		Assert.assertTrue(reponse.isSuccess()==Boolean.TRUE);
	}

}
