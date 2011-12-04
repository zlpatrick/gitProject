package com.boshi.protocol.detail;

import java.net.Socket;

import com.boshi.entity.GameHouse;
import com.boshi.entity.User;
import com.boshi.packet.BoshiPacket;
import com.boshi.protocol.BoshiProtocol;
import com.boshi.server.BoshiServer;
import com.boshi.util.ByteArrayUtil;
import com.boshi.util.DataTypeUtil;
import com.boshi.util.ProtocolUtil;

public class CreateGameHouseProtocol extends BoshiProtocol
{
	public void process(BoshiPacket packet, Socket userSocket) throws Exception {
		// TODO Auto-generated method stub
		byte[] packetContent = packet.getContent( );
		byte[] userIDBytes = ByteArrayUtil.getByteArrayInterval(packetContent, 0, 15);
		String userID = new String(userIDBytes);
		int houseNameLength = DataTypeUtil.byteToInt(ByteArrayUtil.getByteArrayInterval(packetContent, 16, 19));
		String houseName = DataTypeUtil.getStringFromBytes(ByteArrayUtil.getByteArrayInterval(packetContent, 20, 20+houseNameLength));
		
		byte[] resultContent = null;
		GameHouse[] houseList = BoshiServer.getHouseList();
		GameHouse house = new GameHouse(houseList[houseList.length-1].getHouseID()+1);
		house.setCreatorID(userID);
		house.setHouseType(GameHouse.USERCREATED);
		house.setName(houseName);
		house.userEnter(new User(userID));
		
		resultContent = ProtocolUtil.getGameHouseDetailBytes(house.getHouseID());
		BoshiServer.createHouse(house);
		
		userSocket.getOutputStream().write(resultContent);
	}
}
