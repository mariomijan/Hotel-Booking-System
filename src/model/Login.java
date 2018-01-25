package model;

public class Login
{
	private int id;
	private String userName;
	private String password;
	private LoginRole role;
	// True if person is logged in
	private Boolean status;

	public Login(int id, String userName, String password, LoginRole role)
	{
		this.id = id;
		this.userName = userName;
		this.password = password;
		this.role = role;
		this.status = false;
	}

	public Login(String userName, String password, LoginRole role)
	{
		this.userName = userName;
		this.password = password;
		this.role = role;
		this.status = false;
	}

	public String getUserName()
	{
		return userName;
	}

	public void setUserName(String userName)
	{
		this.userName = userName;
	}

	public String getPassword()
	{
		return password;
	}

	public void setPassword(String password)
	{
		this.password = password;
	}

	public LoginRole getRole()
	{
		return role;
	}

	public void setRole(LoginRole role)
	{
		this.role = role;
	}

	public int getId()
	{
		return id;
	}

	public Boolean getStatus()
	{
		return status;
	}

	public void setStatus(Boolean status)
	{
		this.status = status;
	}

}
