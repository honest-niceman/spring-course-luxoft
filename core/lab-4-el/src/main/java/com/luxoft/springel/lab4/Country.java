package com.luxoft.springel.lab4;

import java.io.Serializable;

public class Country implements Serializable {

	private static final long serialVersionUID = 1L;

	private int id;
	private String name;
	private String codeName;
	private City capital;
	private String fullCapitalInfo;

	public Country() {
	}

	public Country(int id, String name, String codeName) {
		this.id = id;
		this.name = name;
		this.codeName = codeName;
	}

	public Country(String name, String codeName) {
		this.name = name;
		this.codeName = codeName;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCodeName() {
		return codeName;
	}

	public void setCodeName(String codeName) {
		this.codeName = codeName;
	}
	
	public City getCapital() {
		return capital;
	}

	public void setCapital(City capital) {
		this.capital = capital;
	}

	public String getFullCapitalInfo() {
		return fullCapitalInfo;
	}

	public void setFullCapitalInfo(String fullCapitalInfo) {
		this.fullCapitalInfo = fullCapitalInfo;
	}
	
	public String toString() {
		return id + ". " + name + " (" + codeName + ")";
	}

	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;

		Country country = (Country) o;

		if (id != country.id)
			return false;
		if (codeName != null ? !codeName.equals(country.codeName) : country.codeName != null)
			return false;
		if (name != null ? !name.equals(country.name) : country.name != null)
			return false;
		if (capital != null ? !capital.equals(country.capital) : country.capital != null)
			return false;

		return true;
	}

	public int hashCode() {
		int result = 0;
		result = 31 * result + (name != null ? name.hashCode() : 0);
		result = 31 * result + (codeName != null ? codeName.hashCode() : 0);
		return result;
	}
}
