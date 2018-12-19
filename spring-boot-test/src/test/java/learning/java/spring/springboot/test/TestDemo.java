package learning.java.spring.springboot.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import learning.java.spring.springboot.SpringBootStarter;

@RunWith(SpringRunner.class) // 底层使用Junit
@SpringBootTest(classes= {SpringBootStarter.class}) // 启动springboot工程
@AutoConfigureMockMvc
public class TestDemo {
	
	@Autowired
	private MockMvc mockServer;
	
	@Test
	public void mockServer() throws Exception {
		MvcResult result = mockServer.perform(MockMvcRequestBuilders.get("/"))
				.andExpect(MockMvcResultMatchers.status().isOk()).andReturn();
		MockHttpServletResponse response = result.getResponse();
		String content = response.getContentAsString();
		System.out.println(content);
	}
	
}
