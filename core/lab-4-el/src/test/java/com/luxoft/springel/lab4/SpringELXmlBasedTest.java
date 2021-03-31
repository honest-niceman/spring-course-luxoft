package com.luxoft.springel.lab4;
import static org.junit.Assert.*;

import org.junit.*;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;
import java.util.ArrayList;

public class SpringELXmlBasedTest {
	
	private static final String APPLICATION_CONTEXT_XML_FILE_NAME = "application-context.xml";
	private AbstractApplicationContext context;
	private UsualPerson expectedPerson;
	private Country expectedCountry;

	@Before
	public void setUp() {
		context = new ClassPathXmlApplicationContext(APPLICATION_CONTEXT_XML_FILE_NAME);
		expectedPerson = getExpectedPerson();
		expectedCountry = getExpectedCountry();
	}

	@Test
	public void testInitCountry() {
		Country country = (Country)  context.getBean("russiaBean");
		assertEquals(expectedCountry, country);
		assertEquals("Moscow, population: 11000000", country.getFullCapitalInfo());
		System.out.println(country);
	}
	
	
	@Test
	public void testInitPerson() {
		UsualPerson person = (UsualPerson) context.getBean("russianPersonBean");
//		FYI: Another way to achieve the bean
//		person = context.getBean(UsualPerson.class);
		assertEquals(expectedPerson, person);
		System.out.println(person);

	}

	private UsualPerson getExpectedPerson() {
		UsualPerson person = new UsualPerson();
		person.setId(1);
		person.setAge(35);
		person.setHeight(1.78F);
		person.setIsProgrammer(true);
		person.setName("Ivan Ivanov");

		person.setCountry(getExpectedCountry());

		List<String> contacts = new ArrayList<String>();
		contacts.add("asd@asd.ru");
		contacts.add("+7-234-456-67-89");

		person.setContacts(contacts);

		return person;
	}
	
	private Country getExpectedCountry() {
		Country country = new Country();
		country.setId(1);
		country.setName("Russia");
		country.setCodeName("RU");
		
		City capital = new City();
		capital.setId(1);
		capital.setName("Moscow");
		capital.setPopulation(11000000);
		
		country.setCapital(capital);

		return country;
	}
	
	@After
	public void tearDown() {
		context.close();
	}
}
