package com.luxoft.springaop.lab5.model;

import java.io.Serializable;

public class CountryImpl implements Serializable, Country {

	private static final long serialVersionUID = 1L;

	private int id;

    private String name;

    private String codeName;

    public CountryImpl() {
    }

    public CountryImpl(int id, String name, String codeName) {
        this.id = id;
        this.name = name;
        this.codeName = codeName;
    }

    public CountryImpl(String name, String codeName) {
        this.name = name;
        this.codeName = codeName;
    }

    /* (non-Javadoc)
	 * @see lab.model.Country#getId()
	 */
    @Override
	public int getId() {
        return id;
    }

    /* (non-Javadoc)
	 * @see lab.model.Country#setId(int)
	 */
    @Override
	public void setId(int id) {
        this.id = id;
    }

    /* (non-Javadoc)
	 * @see lab.model.Country#getName()
	 */
    @Override
	public String getName() {
        return name;
    }

    /* (non-Javadoc)
	 * @see lab.model.Country#setName(java.lang.String)
	 */
    @Override
	public void setName(String name) {
        this.name = name;
    }

    /* (non-Javadoc)
	 * @see lab.model.Country#getCodeName()
	 */
    @Override
	public String getCodeName() {
        return codeName;
    }

    /* (non-Javadoc)
	 * @see lab.model.Country#setCodeName(java.lang.String)
	 */
    @Override
	public void setCodeName(String codeName) {
        this.codeName = codeName;
    }

    public String toString() {
        return id + ". " + name + " (" + codeName + ")";
    }

    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Country country = (Country) o;

        if (codeName != null ? !codeName.equals(country.getCodeName()) : country.getCodeName()!= null) return false;
        if (name != null ? !name.equals(country.getName()) : country.getName() != null) return false;

        return true;
    }

    /* (non-Javadoc)
	 * @see lab.model.Country#hashCode()
	 */
    @Override
	public int hashCode() {
        int result = 0;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (codeName != null ? codeName.hashCode() : 0);
        return result;
    }
}
