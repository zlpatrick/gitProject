package com.boshi.entity;

import java.util.HashMap;
import java.util.Map;

public class GameHouse {

	private int personCount;
	private int houseID;
	private int houseType;
	private int status;
	@SuppressWarnings("rawtypes")
	private Map userMap;
	
	@SuppressWarnings("rawtypes")
	public GameHouse(int houseID)
	{
		this.houseID = houseID;
		this.userMap = new HashMap();
	}
	
	public void setStatus( int status )
	{
		this.status = status;
	}
	
	public int getStatus()
	{
		return this.status;
	}
	
	@SuppressWarnings("rawtypes")
	public GameHouse(int houseID,int houseType)
	{
		this.houseID = houseID;
		this.houseType = houseType;
		this.userMap = new HashMap();
	}
	
	public int getHouseType()
	{
		return this.houseType;
	}
	
	public void setHouseType( int houseType )
	{
		this.houseType = houseType;
	}
	
	public int getHouseID()
	{
		return this.houseID;
	}
	
	public int getPersonCount()
	{
		return this.personCount;
	}
	
	@SuppressWarnings("unchecked")
	public synchronized void userEnter(User user)
	{
		this.userMap.put(user.getUserID(), user);
		this.personCount++;
	}
	
	public synchronized void userLeave(User user)
	{
		this.userMap.remove(user.getUserID());
		this.personCount--;
	}
	
	public User getUser(String userID)
	{
		if(userMap.containsKey(userID))
		{
			return (User)userMap.get(userID);
		}
		return null;
	}
	
	
}
