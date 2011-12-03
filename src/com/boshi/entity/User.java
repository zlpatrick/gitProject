package com.boshi.entity;

public class User {
	
	private String userID;
	private String headUrl;
	private int score;
	
	public User( String userID )
	{
		this.userID = userID;
	}
	
	public void setScore(int score)
	{
		this.score = score;
	}
	
	public int getScore()
	{
		return this.score;
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
