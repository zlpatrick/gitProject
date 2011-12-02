
package com.boshi.protocol.detail;

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

public class EnterHouseListProtocol extends BoshiProtocol
{

	@Override
	public void process( BoshiPacket packet, Socket userSocket ) throws Exception
	{
		// TODO Auto-generated method stub
		byte[] packetContent = packet.getContent( );
		byte[] userIDBytes = ByteArrayUtil.getByteArrayInterval(packetContent, 0, 15);
		String userID = new String(userIDBytes);
		User user = new User(userID);

		BoshiServer.userEnter( user, userSocket );
		List<byte[]> resultList = new ArrayList<byte[]>( );
		int totalUserInHall = BoshiServer.getUsersInHouseHall( ).length;

		resultList.add( userIDBytes );
		resultList.add( DataTypeUtil.intToByteArray( totalUserInHall ) );
		GameHouse[] houses = BoshiServer.getHouseList( );
		int totalHouseCount = houses.length;
		resultList.add( DataTypeUtil.intToByteArray( totalHouseCount ) );
		
		for ( int i = 0; i < totalHouseCount; i++ )
		{
			GameHouse house = houses[i];
			resultList.add( DataTypeUtil.intToByteArray( house.getStatus( ) ) );
			resultList.add( DataTypeUtil.intToByteArray( house.getPersonCount( ) ) );
			User[] users = house.getUserList( );
			resultList.add( DataTypeUtil.intToByteArray( users.length ) );
			for ( int j = 0; j < users.length; j++ )
			{
				resultList.add( DataTypeUtil.getFixedLengthStringBytes( users[j].getUserID( ), USERIDLENGTH ) );
				byte[] userHeadUrlBytes = DataTypeUtil.getStringBytes( users[j].getUserHeadUrl( ) );
				resultList.add( DataTypeUtil.intToByteArray( userHeadUrlBytes.length ) );
				resultList.add( userHeadUrlBytes );
			}
		}
		byte[] resultBytes = ByteArrayUtil.getUnitedByteArrayFromList( resultList );
		userSocket.getOutputStream( ).write( resultBytes );
	}
}
