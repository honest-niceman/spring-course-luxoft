package com.luxoft.springdb.lab2.model;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "COUNTRY")
public class Country implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@Column(nullable = false)
	private int id;

	private String name;

	private String codeName;

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

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@Column
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Column(name="code_name")
	public String getCodeName() {
		return codeName;
	}

	public void setCodeName(String codeName) {
		this.codeName = codeName;
	}

	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;

		Country country = (Country) o;

		if (codeName != null ? !codeName.equals(country.codeName) : country.codeName != null)
			return false;
		if (name != null ? !name.equals(country.name) : country.name != null)
			return false;

		return true;
	}

	public int hashCode() {
		int result = 0;
		result = 31 * result + (name != null ? name.hashCode() : 0);
		result = 31 * result + (codeName != null ? codeName.hashCode() : 0);
		return result;
	}

	@Override
	public String toString() {
		return "Country [id=" + id + ", name=" + name + ", codeName=" + codeName + "]";
	}
}
