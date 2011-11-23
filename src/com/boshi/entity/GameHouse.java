package com.boshi.entity;

import java.util.HashMap;
import java.util.Map;

public class GameHouse {

	private int personCount;
	private int houseID;
	private Map userMap;
	
	public GameHouse(int houseID)
	{
		this.houseID = houseID;
		this.userMap = new HashMap();
	}
	
	public int getHouseID()
	{
		return this.houseID;
	}
	
	public int getPersonCount()
	{
		return this.personCount;
	}
	
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
