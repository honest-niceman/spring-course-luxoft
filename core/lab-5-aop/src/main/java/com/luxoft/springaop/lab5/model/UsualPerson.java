package com.luxoft.springaop.lab5.model;

import java.util.List;

public class UsualPerson implements Person {
    private int id;

    private String name;

    private Country country;

    private int age;
    private float height;
    private boolean isProgrammer;

    private List<String> contacts;

    /* (non-Javadoc)
	 * @see lab.model.Person1#setIsProgrammer(boolean)
	 */
    @Override
	public void setIsProgrammer(boolean isProgrammer) {
        this.isProgrammer = isProgrammer;
    }

    /* (non-Javadoc)
	 * @see lab.model.Person1#setAge(int)
	 */
    @Override
	public void setAge(int age) {
        this.age = age;
    }

    /* (non-Javadoc)
	 * @see lab.model.Person1#setHeight(float)
	 */
    @Override
	public void setHeight(float height) {
        this.height = height;
    }

    /* (non-Javadoc)
	 * @see lab.model.Person1#setName(java.lang.String)
	 */
    @Override
	public void setName(String name) {
        this.name = name;
    }

    /* (non-Javadoc)
	 * @see lab.model.Person1#getName()
	 */
    @Override
	public String getName() {
        return name;
    }

    /* (non-Javadoc)
	 * @see lab.model.Person1#sayHello(lab.model.Person)
	 */
    @Override
	public void sayHello(Person person) {
    }

    /* (non-Javadoc)
	 * @see lab.model.Person1#getCountry()
	 */
    @Override
	public Country getCountry() {
        return country;
    }

    /* (non-Javadoc)
	 * @see lab.model.Person1#setCountry(lab.model.Country)
	 */
    @Override
	public void setCountry(Country country) {
        this.country = country;
    }

    /* (non-Javadoc)
	 * @see lab.model.Person1#isProgrammer()
	 */
    @Override
	public boolean isProgrammer() {
        return isProgrammer;
    }

    /* (non-Javadoc)
	 * @see lab.model.Person1#setProgrammer(boolean)
	 */
    @Override
	public void setProgrammer(boolean programmer) {
        isProgrammer = programmer;
    }

    /* (non-Javadoc)
	 * @see lab.model.Person1#getContacts()
	 */
    @Override
	public List<String> getContacts() {
        return contacts;
    }

    /* (non-Javadoc)
	 * @see lab.model.Person1#setContacts(java.util.List)
	 */
    @Override
	public void setContacts(List<String> contacts) {
        this.contacts = contacts;
    }

    /* (non-Javadoc)
	 * @see lab.model.Person1#getId()
	 */
    @Override
	public int getId() {
        return id;
    }

    /* (non-Javadoc)
	 * @see lab.model.Person1#setId(int)
	 */
    @Override
	public void setId(int id) {
        this.id = id;
    }

    public String toString() {
        String s = "Name: " + name + "\n"
                + "Age: " + age + "\n"
                + "Height: " + height + "\n"
                + "Country: " + country + "\n"
                + "Is Programmer?: " + isProgrammer + "\n";
        if ((contacts != null) && (!contacts.isEmpty())) {
            s += "Contacts: ";
            for (String contact : contacts) {
                s += contact + ", ";
            }
            s += "\n";
        }
        return s;
    }

    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        UsualPerson person = (UsualPerson) o;

        if (age != person.age) return false;
        if (Float.compare(person.height, height) != 0) return false;
        if (isProgrammer != person.isProgrammer) return false;
        if (country != null ? !country.equals(person.country) : person.country != null) return false;
        if (name != null ? !name.equals(person.name) : person.name != null) return false;

        return true;
    }

    /* (non-Javadoc)
	 * @see lab.model.Person1#hashCode()
	 */
    @Override
	public int hashCode() {
        int result;
        result = (name != null ? name.hashCode() : 0);
        result = 31 * result + age;
        result = 31 * result + (height != +0.0f ? Float.floatToIntBits(height) : 0);
        result = 31 * result + (isProgrammer ? 1 : 0);
        result = 31 * result + (country != null ? country.hashCode() : 0);
        return result;
    }
}