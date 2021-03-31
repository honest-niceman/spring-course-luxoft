package com.luxoft.springcore.events;

import org.springframework.context.ApplicationEvent;

import com.luxoft.springcore.objects.City;
import com.luxoft.springcore.objects.Person;

public class TravelEvent extends ApplicationEvent {

	private static final long serialVersionUID = -4094227952486126831L;
	
	private Person person;
	private City travellingDestination;

	public TravelEvent(Person person, City travellingDestination) {
		super(person);
		this.person = person;
		this.travellingDestination = travellingDestination;
	}
	
	public Person getPerson() {
		return person;
	}
	
	public City getTravellingDestination() {
		return travellingDestination;
	}

}
