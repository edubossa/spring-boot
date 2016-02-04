package com.example;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.web.WebAppConfiguration;

import br.com.ews.SpringBootDemoWebappApplication;

import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = SpringBootDemoWebappApplication.class)
@WebAppConfiguration
public class SpringBootDemoWebappApplicationTests {

	@Test
	public void contextLoads() {
	}

}
