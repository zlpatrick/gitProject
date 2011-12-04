package com.boshi.util;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

import com.boshi.api.IBoshiProtocol;
import com.boshi.entity.GameHouse;
import com.boshi.entity.User;
import com.boshi.server.BoshiServer;

public class ProtocolUtil 
{
	
	public static byte[] getGameHouseDetailBytes( int houseID ) throws UnsupportedEncodingException
	{
		GameHouse house = BoshiServer.getHouse(houseID);
		List<byte[]> resultList = new ArrayList<byte[]>();
		resultList.add(DataTypeUtil.intToByteArray(houseID));
		byte[] nameBytes = DataTypeUtil.getStringBytes(house.getName());
		resultList.add(DataTypeUtil.intToByteArray(nameBytes.length));
		resultList.add(nameBytes);
		resultList.add(DataTypeUtil.getFixedLengthStringBytes(house.getCreatorID(), IBoshiProtocol.USERIDLENGTH));
		resultList.add(DataTypeUtil.intToByteArray(house.getPersonCount()));
		User[] users = house.getUserList();
		for(int i = 0; i < users.length;i++)
		{
			resultList.add(DataTypeUtil.getFixedLengthStringBytes(users[i].getUserID(), IBoshiProtocol.USERIDLENGTH));
			byte[] headUrlLength = DataTypeUtil.getStringBytes(users[i].getUserHeadUrl());
			resultList.add(DataTypeUtil.intToByteArray(headUrlLength.length));
			resultList.add(headUrlLength);
			resultList.add(DataTypeUtil.intToByteArray(users[i].getScore()));
		}
		return ByteArrayUtil.getUnitedByteArrayFromList(resultList);
	}
}
