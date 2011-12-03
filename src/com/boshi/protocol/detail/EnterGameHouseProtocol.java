package com.boshi.protocol.detail;

import java.io.UnsupportedEncodingException;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

import com.boshi.entity.GameHouse;
import com.boshi.entity.User;
import com.boshi.packet.BoshiPacket;
import com.boshi.protocol.BoshiProtocol;
import com.boshi.server.BoshiServer;
import com.boshi.util.ByteArrayUtil;
import com.boshi.util.DataTypeUtil;

public class EnterGameHouseProtocol extends BoshiProtocol
{

	@Override
	public void process(BoshiPacket packet, Socket userSocket) throws Exception {
		// TODO Auto-generated method stub
		byte[] packetContent = packet.getContent( );
		byte[] userIDBytes = ByteArrayUtil.getByteArrayInterval(packetContent, 0, 15);
		String userID = new String(userIDBytes);
		int houseID = DataTypeUtil.byteToInt(ByteArrayUtil.getByteArrayInterval(packetContent, 16, 19));
		
		byte[] resultContent = null;
		if( houseID==0)
		{
			GameHouse[] houses = BoshiServer.getHouseList();
			for( int i=0;i<houses.length;i++)
			{
				if(houses[i].getStatus()==0)
					houseID = houses[i].getHouseID();
			}
		}	
		resultContent = getGameHouseDetailBytes(houseID);
		
		BoshiServer.getHouse(houseID).userEnter(new User(userID));
	}

	private byte[] getGameHouseDetailBytes( int houseID ) throws UnsupportedEncodingException
	{
		GameHouse house = BoshiServer.getHouse(houseID);
		List<byte[]> resultList = new ArrayList<byte[]>();
		resultList.add(DataTypeUtil.intToByteArray(houseID));
		byte[] nameBytes = DataTypeUtil.getStringBytes(house.getName());
		resultList.add(DataTypeUtil.intToByteArray(nameBytes.length));
		resultList.add(nameBytes);
		resultList.add(DataTypeUtil.getFixedLengthStringBytes(house.getCreatorID(), USERIDLENGTH));
		resultList.add(DataTypeUtil.intToByteArray(house.getPersonCount()));
		User[] users = house.getUserList();
		for(int i = 0; i < users.length;i++)
		{
			resultList.add(DataTypeUtil.getFixedLengthStringBytes(users[i].getUserID(), USERIDLENGTH));
			byte[] headUrlLength = DataTypeUtil.getStringBytes(users[i].getUserHeadUrl());
			resultList.add(DataTypeUtil.intToByteArray(headUrlLength.length));
			resultList.add(headUrlLength);
			resultList.add(DataTypeUtil.intToByteArray(users[i].getScore()));
		}
		return ByteArrayUtil.getUnitedByteArrayFromList(resultList);
	}
}
