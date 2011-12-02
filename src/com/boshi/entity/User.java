package com.boshi.entity;

public class User {
	
	private String userID;
	private String headUrl;
	
	public User( String userID )
	{
		this.userID = userID;
	}
	
	public String getUserID( )
	{
		return this.userID;
	}
	
	public String getUserHeadUrl()
	{
		return this.headUrl;
	}
	
	public void setUserHeadUrl(String headUrl)
	{
		this.headUrl = headUrl;
	}
}
