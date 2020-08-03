package javaSchool.Task000;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import javaSchool.Task000.repos.URLShortenerRepository;

@RunWith(SpringRunner.class)
@WebMvcTest(URLShortenerController.class)
public class URLShortenerControllerTest {
	@Autowired
	private MockMvc mvc;
	
	@MockBean
	private URLShortenerRepository repo;
	
	@Test
	public void testBasicResponse() throws Exception {
		mvc.perform(get("/").contentType(MediaType.APPLICATION_JSON))
		   .andExpect(status().isOk());
	}
	
	@Test
	public void testURLShortening() throws Exception {
		mvc.perform(post("/").contentType(MediaType.APPLICATION_JSON)
							 .content("{\"url\": \"www.google.com/helloWorld\"}"))
		   .andExpect(status().isOk());
	}
	
	@Test
	public void testURLLookupNoResult() throws Exception {
		mvc.perform(get("/BpwK").contentType(MediaType.APPLICATION_JSON))
		   .andExpect(status().is4xxClientError());
	}
}
