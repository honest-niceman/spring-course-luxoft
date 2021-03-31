package com.luxoft.springioc.lab1.model;

import static org.junit.Assert.*;

import org.junit.*;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

import com.luxoft.springioc.lab1.model.Country;
import com.luxoft.springioc.lab1.model.Person;
import com.luxoft.springioc.lab1.model.UsualPerson;

public class HelloWorldTest {

	protected static final String APPLICATION_CONTEXT_XML_FILE_NAME = "classpath:application-context.xml";

	private UsualPerson expectedPerson;

	private AbstractApplicationContext context;

	@Before
	public void setUp() throws Exception {
		context = new FileSystemXmlApplicationContext(new String[] { APPLICATION_CONTEXT_XML_FILE_NAME });
		expectedPerson = getExpectedPerson();
	}

	@Test
	public void testInitPerson() {
		UsualPerson person = (UsualPerson) context.getBean("person", Person.class);

		System.out.println("-->" + person.getCountry().getA());
//		assertEquals(expectedPerson, person);
//		System.out.println(person);
	}

	private UsualPerson getExpectedPerson() {
		UsualPerson person = new UsualPerson();
		person.setAge(35);
		person.setName("John Smith");

		Country country = new Country();
		country.setId(1);
		country.setName("Russia");
		country.setCodeName("RU");

		System.out.println("-->" + country.getA());

		person.setCountry(country);

		return person;
	}

	@After
	public void tearDown() throws Exception {
		if (context != null)
			context.close();
	}
}
