package com.mindtree;

import static org.mockito.Mockito.when ;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.mindtree.controller.PatientController;
import com.mindtree.entity.Patient;
import com.mindtree.service.IPatientService;

@ComponentScan(basePackages = "com.mindtree")
@TestMethodOrder(OrderAnnotation.class)
@ContextConfiguration
@AutoConfigureMockMvc
@SpringBootTest(classes= {ApplicationTests.class})
class ApplicationTests {

	@Autowired
	MockMvc mockMvc;
	
	@Mock
	IPatientService patService;
	
	@InjectMocks
	PatientController patController;
	
	@BeforeEach
	private void setUp() {
		mockMvc = MockMvcBuilders.standaloneSetup(patController).build();
	}
	
	List<Patient> patList;
	Patient pat;
	
	@Test
	@Order(1)
	public void testGetAllPatients() throws Exception {
		
		patList = new ArrayList<>();
		
		patList.add(new Patient(1,"Ravana","Ram",new Date(0),"Check up"));
		patList.add(new Patient(2,"Don","Seetha",new Date(0),"Test"));
		
		when(patService.fetchAllPatients()).thenReturn(patList);
		
		this.mockMvc.perform(get("/patient/getAllPatients"))
												.andExpect(status().isOk());
	}
	
	@Test
	@Order(2)
	public void testGetAPatient() throws Exception {
		
		pat = new Patient(1,"Ravana","Ram",new Date(0),"Check up");
		
		int id = 1;
		
		when(patService.fetchAPatient(id)).thenReturn(pat);
		
		this.mockMvc.perform(get("/patient/getPatient/{id}",id))
												.andDo(print())
												.andExpect(status().isOk())
												.andExpect(MockMvcResultMatchers.jsonPath(".id").value(id));
		
	}
	
	@Test
	@Order(3)
	public void testAddPatient() throws Exception {
		
		pat = new Patient(2,"Don","Seetha",new Date(0),"Test");
		
		ObjectMapper mapper = new ObjectMapper();
		
		String jsonBody = mapper.writeValueAsString(pat);
		
		when(patService.addPatient(pat)).thenReturn(pat);
		
		this.mockMvc.perform(post("/patient/add", jsonBody)
												.content(jsonBody)
												.contentType(MediaType.APPLICATION_JSON))
												.andExpect(status().isCreated())
												.andExpect(MockMvcResultMatchers.jsonPath(".id").value(2));
		
	}

}
