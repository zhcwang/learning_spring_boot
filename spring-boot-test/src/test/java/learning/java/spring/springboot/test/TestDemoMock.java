package learning.java.spring.springboot.test;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import junit.framework.TestCase;
import learning.java.spring.springboot.SpringBootStarter;

@RunWith(SpringRunner.class) // 底层使用Junit
@SpringBootTest(classes= {SpringBootStarter.class}) // 启动springboot工程
public class TestDemoMock {
	
	@Before
	public void before() {
		System.out.println("Spring Junit Test Initial");
	}
	
	@Test
	public void testOne() {
		System.out.println("Spring Junit Test ...");
		TestCase.assertEquals(1, 1);
	}
	
	@Test
	public void testTwo() {
		System.out.println("Spring Junit Test ...");
		TestCase.assertEquals(1, 1);
	}
	
	@After
	public void after() {
		System.out.println("Spring Junit Test Complete");
	}
	
}
