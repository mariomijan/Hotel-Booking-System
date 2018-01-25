package model;

public class GuestOrigin
{
	private int id;
	private String country;
	private String postalCode;
	private String city;

	public GuestOrigin(int id, String country, String postalCode, String city)
	{
		this.id = id;
		this.country = country;
		this.postalCode = postalCode;
		this.city = city;
	}

	public GuestOrigin(String country, String postalCode, String city)
	{
		this.country = country;
		this.postalCode = postalCode;
		this.city = city;
	}

	/**
	 * @return the id
	 */
	public int getId()
	{
		return id;
	}

	/**
	 * @param id
	 *            the id to set
	 */
	public void setId(int id)
	{
		this.id = id;
	}

	/**
	 * @return the country
	 */
	public String getCountry()
	{
		return country;
	}

	/**
	 * @param country
	 *            the country to set
	 */
	public void setCountry(String country)
	{
		this.country = country;
	}

	/**
	 * @return the postalCode
	 */
	public String getPostalCode()
	{
		return postalCode;
	}

	/**
	 * @param postalCode
	 *            the postalCode to set
	 */
	public void setPostalCode(String postalCode)
	{
		this.postalCode = postalCode;
	}

	/**
	 * @return the city
	 */
	public String getCity()
	{
		return city;
	}

	/**
	 * @param city
	 *            the city to set
	 */
	public void setCity(String city)
	{
		this.city = city;
	}

}
