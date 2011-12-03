package com.boshi.entity;

import java.util.HashMap;
import java.util.Map;

public class GameHouse {

	private int personCount;
	private String name;
	private int houseID;
	private int houseType;
	private int status;
	private String creatorID;
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
	
	public void setCreatorID(String ID)
	{
		this.creatorID = ID;
	}
	
	public String getCreatorID()
	{
		return this.creatorID;
	}
	
	public int getStatus()
	{
		return this.status;
	}
	
	public String getName()
	{
		return this.name;
	}
	
	public void setName(String name)
	{
		this.name= name;
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
	
	public User[] getUserList()
	{
		return (User[])this.userMap.values( ).toArray( );
	}
}
