package com.luxoft.springel.lab4;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class OperatorsXmlBasedTest {
	
	private static final String APPLICATION_CONTEXT_XML_FILE_NAME = "application-context.xml";
	private AbstractApplicationContext context;
	
	@Before
	public void setUp() throws Exception {
		context = new ClassPathXmlApplicationContext(APPLICATION_CONTEXT_XML_FILE_NAME);
	}
	
	@Test
	public void testLessThen() {
		Operators op = (Operators) context.getBean("operatorsBean");
		assertTrue(op.isLessThanTest());
	}

	@Test
	public void testAdd() {
		Operators op = (Operators) context.getBean("operatorsBean");
		assertEquals(op.getAddTest(), 14000000);
	}

	@After
	public void tearDown() {
		context.close();
	}

}