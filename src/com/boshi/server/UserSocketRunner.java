
package com.boshi.server;

import java.io.IOException;
import java.net.Socket;

import com.boshi.api.IBoshiProtocol;
import com.boshi.packet.BoshiPacket;
import com.boshi.util.BoshiPacketUtil;
import com.boshi.util.BoshiProtocolFactory;

public class UserSocketRunner implements Runnable
{

	private Socket userSocket;

	public UserSocketRunner( Socket socket )
	{
		this.userSocket = socket;
	}

	public void run( )
	{
		while ( true )
		{
			try
			{
				byte[] packetBuffer = new byte[100];
				int length = this.userSocket.getInputStream( ).read( packetBuffer );
				BoshiPacket boshiPacket = BoshiPacketUtil.generateBoshiPacket( length,packetBuffer );
				IBoshiProtocol procol = BoshiProtocolFactory.createBProtocol( boshiPacket.getCommandID( ) );
				procol.process( boshiPacket, userSocket );
			}
			catch ( IOException e )
			{
				e.printStackTrace( );
			}
		}

	}

}
