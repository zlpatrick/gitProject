
package com.boshi.server;

import java.io.IOException;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.HashMap;
import java.util.Map;

public class BoshiServer
{

	private ServerSocket serverSocket;
	
	private static Map<String,Socket> userSocketMap = new HashMap<String,Socket>();

	public BoshiServer( int port ) throws IOException
	{
		serverSocket = new ServerSocket( port );
	}

	public BoshiServer( String host, int port ) throws UnknownHostException,
			IOException
	{
		serverSocket = new ServerSocket( port, 0, InetAddress.getByName( host ) );
	}

	public static void userEnter(String userid, Socket userSocket)
	{
		userSocketMap.put( userid, userSocket );
	}
	
	public static Socket getUserSocket( String userid )
	{
		if ( userSocketMap.containsKey( userid ) )
		{
			return userSocketMap.get( userid );
		}
		else
			return null;
	}
	
	public static void main( String[] args ) throws IOException
	{
		BoshiServer server = new BoshiServer( 8000 );

		while ( true )
		{
			Socket socket = server.serverSocket.accept( );
			UserSocketRunner userSocketRunner = new UserSocketRunner( socket );
			Thread userThread = new Thread( userSocketRunner );
			userThread.start( );
		}
	}
}
