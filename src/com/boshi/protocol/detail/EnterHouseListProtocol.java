package com.boshi.protocol.detail;

import java.net.Socket;

import com.boshi.entity.User;
import com.boshi.packet.BoshiPacket;
import com.boshi.protocol.BoshiProtocol;
import com.boshi.server.BoshiServer;
import com.boshi.util.ByteArrayUtil;


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
	}

}
