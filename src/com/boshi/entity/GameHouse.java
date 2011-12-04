package com.boshi.entity;

import java.util.HashMap;
import java.util.Map;

public class GameHouse {

	private int personCount;
	private String name = "小博士游戏房间";
	private int houseID;
	private int houseType = 0;
	private int status = 0;
	private String creatorID;
	public static int SYSTEMCREATED = 0;
	public static int USERCREATED = 1;
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
