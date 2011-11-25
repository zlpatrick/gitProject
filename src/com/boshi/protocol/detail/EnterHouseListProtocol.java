package com.boshi.protocol.detail;

import java.net.Socket;

import com.boshi.packet.BoshiPacket;
import com.boshi.protocol.BoshiProtocol;


public class EnterHouseListProtocol extends BoshiProtocol
{

	@Override
	public void process( BoshiPacket packet, Socket userSocket )
	{
		// TODO Auto-generated method stub
		byte[] packetContent = packet.getContent( );
	}

}
