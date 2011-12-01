package com.boshi.protocol.detail;

import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

import com.boshi.entity.User;
import com.boshi.packet.BoshiPacket;
import com.boshi.protocol.BoshiProtocol;
import com.boshi.server.BoshiServer;
import com.boshi.util.ByteArrayUtil;
import com.boshi.util.DataTypeUtil;


public class EnterHouseListProtocol extends BoshiProtocol
{

	@Override
	public void process( BoshiPacket packet, Socket userSocket )
	{
		// TODO Auto-generated method stub
		byte[] packetContent = packet.getContent( );
		byte[] userIDBytes = ByteArrayUtil.getByteArrayInterval(packetContent, 0, 15);
		String userID = new String(userIDBytes);
		User user = new User(userID);
		
		BoshiServer.userEnter(user, userSocket);
		List<byte[]> resultList = new ArrayList<byte[]>();
		int totalUserInHall = BoshiServer.getUsersInHouseHall().length;
		
		resultList.add(userIDBytes);
		resultList.add(DataTypeUtil.intToByteArray(totalUserInHall));
		int totalHouseCount = BoshiServer.getHouseList().length;
		resultList.add(DataTypeUtil.intToByteArray(totalHouseCount));
		

	}

}
