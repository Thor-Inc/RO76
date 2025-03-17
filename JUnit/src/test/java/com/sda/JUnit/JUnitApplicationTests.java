package com.sda.JUnit;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.sda.JUnit.repository.ProductRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Import;
import org.springframework.http.MediaType;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.hamcrest.CoreMatchers.containsString;
import static org.mockito.Mockito.when;
import static org.springframework.mock.http.server.reactive.MockServerHttpRequest.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
@Import(ProductControllerTestContextConfiguration.class)
class JUnitApplicationTests {

	@Test
	void contextLoads() {

	}

	@Autowired
	private MockMvc mockMvc;

/*	@MockitoBean
	private ProductRepository productRepository;*/

	@Test
	void shouldReturnDefaultMessage() throws Exception {
		this.mockMvc.perform(get("/products/hello")).andDo(print()).andExpect(status().isOk())
				.andExpect(content().string(containsString("Hello, World")));
	}

	@Test
	void testValidateProduct() throws Exception {
			mockMvc.perform(MockMvcRequestBuilders.post("/products/validate")
							.contentType(MediaType.APPLICATION_JSON)
					.content("{ \"id\": 1, \"productName\": \"test\", \"description\" : \"test\", \"productCategory\":\"categ\" }")
					.accept(MediaType.APPLICATION_JSON))
					.andExpect(status().isOk())
					.andExpect(content().string("this is a test"));
	}

	@Test
	void testValidateProductNoTest() throws Exception {
		mockMvc.perform(MockMvcRequestBuilders.post("/products/validate")
						.contentType(MediaType.APPLICATION_JSON)
						.content("{ \"id\": 1, \"productName\": \"none\", \"description\" : \"test\", \"productCategory\":\"categ\" }")
						.accept(MediaType.APPLICATION_JSON))
				.andExpect(status().isOk())
				.andExpect(content().string("no test"));
	}

	@Test
	void testValidateProductNotFound() throws Exception {
		mockMvc.perform(MockMvcRequestBuilders.post("/products/validateProduct")
						.contentType(MediaType.APPLICATION_JSON)
						.content("{ \\\"id\\\": 1, \\\"productName\\\": test, \\\"description\\\" : test, \\\"productCategory\\\":categ }")
						.accept(MediaType.APPLICATION_JSON))
					.andExpect(status().isNotFound())
/*					.andExpect(jsonPath("$.accountId").value("12345"))
					.andExpect(jsonPath("$.accountType").value("SAVINGS"))
					.andExpect(jsonPath("$.balance").value(5000))*/;

	}
}