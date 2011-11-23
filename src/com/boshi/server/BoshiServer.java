package com.boshi.server;

import java.io.IOException;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.UnknownHostException;

public class BoshiServer {

	public ServerSocket ss;
	
	public BoshiServer( int port ) throws IOException
	{
		ss = new ServerSocket( port );
	}
	
	public BoshiServer( String host, int port ) throws UnknownHostException, IOException
	{
		ss = new ServerSocket( port, 0, InetAddress.getByName(host) );
	}
}
