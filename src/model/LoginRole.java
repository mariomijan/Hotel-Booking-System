package model;

public class LoginRole
{
	private int id;
	private String loginRole;

	public LoginRole(int id, String loginRole)
	{
		this.id = id;
		this.loginRole = loginRole;
	}

	public int getId()
	{
		return id;
	}

	public void setId(int id)
	{
		this.id = id;
	}

	public String getLoginRole()
	{
		return loginRole;
	}

	public void setLoginRole(String loginRole)
	{
		this.loginRole = loginRole;
	}
}
