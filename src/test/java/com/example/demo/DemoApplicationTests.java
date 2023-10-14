package com.example.demo;

import com.example.demo.controller.AuthController;
import com.example.demo.controller.HomeController;
import com.example.demo.controller.UserController;
import com.example.demo.model.Person;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;


@SpringBootTest
@AutoConfigureMockMvc
class DemoApplicationTests {

	@Autowired
	private HomeController homeController;

	@Autowired
	private AuthController authController;

	@Autowired
	private UserController userController;

	@Autowired
	private MockMvc mockMvc;

	@Test
	public void contextLoads() throws Exception {
		assertThat(homeController).isNotNull();
		assertThat(authController).isNotNull();
		assertThat(userController).isNotNull();
	}

	@Test
	public void userCreate() throws Exception{
		this.mockMvc.perform(
				post("/auth/registration", new Person("user", "123456789", 1990, "ROLE_USER", "male")));

	}

//	@Test
//	public void shouldReturnDefaultMessage() throws Exception {
//		this.mockMvc.perform(get("/demo/auth/login")).andDo(print()).andExpect(status().isOk())
//				.andExpect(content().);
//	}


}
