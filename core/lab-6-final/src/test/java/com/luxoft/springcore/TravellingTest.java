package com.luxoft.springcore;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

import com.luxoft.springcore.objects.City;
import com.luxoft.springcore.objects.Operators;
import com.luxoft.springcore.objects.UsualPerson;

public class TravellingTest {

	private static final String APPLICATION_CONTEXT_XML_FILE_NAME = "classpath:application-context.xml";
	private City moscow;
	private City warsaw;
	private City krakow; 
	private City sofia;
	private City vienna; 
	
	private UsualPerson russianPerson;
	private UsualPerson bulgarianPerson;
	
	private AbstractApplicationContext context;

	@Before
	public void setUp() {
		context = new FileSystemXmlApplicationContext(new String[] { APPLICATION_CONTEXT_XML_FILE_NAME });
		
		moscow = context.getBean("moscow", City.class);
		warsaw = context.getBean("warsaw", City.class);
		krakow = context.getBean("krakow", City.class);
		sofia = context.getBean("sofia", City.class);
		vienna = context.getBean("vienna", City.class);
	}

	@Test
	public void testInitPersons() {
		russianPerson = (UsualPerson) context.getBean("russianPerson", UsualPerson.class);
		UsualPerson expectedRussianPerson = new UsualPerson("Viktor Ponedelnik", 35, moscow);
		assertEquals(expectedRussianPerson, russianPerson);
		
		bulgarianPerson = (UsualPerson) context.getBean("bulgarianPerson", UsualPerson.class);
		UsualPerson expectedBulgarianPerson = new UsualPerson("Emil Kostadinov", 37, sofia);
		assertEquals(expectedBulgarianPerson, bulgarianPerson);
		
		Operators op = (Operators) context.getBean("operatorsBean");
		assertTrue(op.isAgeComparisonTest());
	}
	
	@Test
	public void testPersonsTravelling() {
		russianPerson = (UsualPerson) context.getBean("russianPerson", UsualPerson.class);
		russianPerson.travel(moscow, warsaw);
		russianPerson.travel(warsaw, krakow);
		assertEquals(russianPerson.getDistanceTravelled(), 1386);
		
		bulgarianPerson = (UsualPerson) context.getBean("bulgarianPerson", UsualPerson.class);
		bulgarianPerson.travel(sofia, vienna);
		bulgarianPerson.travel(vienna, krakow);
		assertEquals(bulgarianPerson.getDistanceTravelled(), 1166);
		
		Operators op = (Operators) context.getBean("operatorsBean");
		assertTrue(op.isDistanceComparisonTest());
	}
	
	@After
	public void tearDown() {
		if (context != null)
			context.close();
	}
}
