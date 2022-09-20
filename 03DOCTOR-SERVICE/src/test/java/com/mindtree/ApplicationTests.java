package com.mindtree;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
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
import com.mindtree.controller.DoctorController;
import com.mindtree.entity.Doctor;
import com.mindtree.service.IDoctorService;

@ComponentScan(basePackages = "com.mindtree")
@TestMethodOrder(OrderAnnotation.class)
@ContextConfiguration
@AutoConfigureMockMvc
@SpringBootTest(classes= {ApplicationTests.class})
class ApplicationTests {

	@Autowired
	MockMvc mockMvc;
	
	@Mock
	IDoctorService docService;
	
	@InjectMocks
	DoctorController docController;
	
	@BeforeEach
	private void setUp() {
		mockMvc = MockMvcBuilders.standaloneSetup(docController).build();
	}
	
	List<Doctor> docList;
	Doctor doc;
	
	@Test
	@Order(1)
	public void testGetAllDoctors() throws Exception {
		
		docList = new ArrayList<>();
		docList.add(new Doctor(1,"Ram",28,"male","brain",0));
		docList.add(new Doctor(2,"Sita",26,"female","heart",0));
		
		when(docService.fetchAllDoctors()).thenReturn(docList);
		
		this.mockMvc.perform(get("/doctor/getAllDoctors"))
												.andExpect(status().isOk());
	}
	
	@Test
	@Order(2)
	public void testGetADoctor() throws Exception {
		
		doc = new Doctor(1,"Ram",28,"male","brain",0);
		
		int id = 1;
		
		when(docService.fetchADoctor(id)).thenReturn(doc);
		
		this.mockMvc.perform(get("/doctor/getDoctor/{id}",id))
												.andExpect(status().isFound())
												.andExpect(MockMvcResultMatchers.jsonPath(".id").value(id));
		
	}
	
	@Test
	@Order(3)
	public void testAddDoctor() throws Exception {
		
		doc = new Doctor(1,"Ram",28,"male","brain",0);
		
		ObjectMapper mapper = new ObjectMapper();
		
		String jsonBody = mapper.writeValueAsString(doc);
		
		when(docService.addDoctor(doc)).thenReturn(doc);
		
		this.mockMvc.perform(post("/doctor/add", jsonBody)
												.content(jsonBody)
												.contentType(MediaType.APPLICATION_JSON))
												.andExpect(status().isCreated())
												.andExpect(MockMvcResultMatchers.jsonPath(".id").value(1));
		
	}
	
	@Test
	@Order(4)
	public void testGetDoctorsNames() throws Exception {
		
		docList = new ArrayList<>();
		docList.add(new Doctor(1,"Ram",28,"male","Heart",0));
		docList.add(new Doctor(2,"Priya",26,"female","Brain",0));
		
		List<String> docNames = new ArrayList<>();
		docNames.add(docList.get(0).getName());
		docNames.add(docList.get(1).getName());
		
       when(docService.fetchAllDoctorsNames()).thenReturn(docNames);
		
       this.mockMvc.perform(get("/doctor/getAllDoctorsNames"))
													.andExpect(status().isOk())
													.andDo(print());
	}
	
	@Test
	@Order(5)
	public void testGetDoctorByName() throws Exception{
		
		doc = new Doctor(1,"Ram",28,"male","brain",0);
		
		String name = "Ram";
		
		when(docService.fetchADoctorByName(name)).thenReturn(doc);
		
		this.mockMvc.perform(get("/doctor/getDoctorByName/{name}",name))
												.andExpect(status().isOk())
												.andExpect(MockMvcResultMatchers.jsonPath(".name").value(name));
		
	}

}
