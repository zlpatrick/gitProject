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
import com.boshi.util.ProtocolUtil;

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
		resultContent = ProtocolUtil.getGameHouseDetailBytes(houseID);
		userSocket.getOutputStream( ).write( resultContent );
	}

}
