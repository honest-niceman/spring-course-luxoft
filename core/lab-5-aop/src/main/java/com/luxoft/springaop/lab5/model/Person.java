package com.luxoft.springaop.lab5.model;

import java.util.List;

public interface Person {
	public void setIsProgrammer(boolean isProgrammer);
	public void setAge(int age);
	public void setHeight(float height);
	public void setName(String name);
	public String getName();
	public void sayHello(Person person);
	public Country getCountry();
	public void setCountry(Country country);
	public boolean isProgrammer();
	public void setProgrammer(boolean programmer);
	public List<String> getContacts();
	public void setContacts(List<String> contacts);
	public int getId();
	public void setId(int id);
}
