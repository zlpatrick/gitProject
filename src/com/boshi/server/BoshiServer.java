
package com.boshi.server;

import java.io.IOException;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.HashMap;
import java.util.Map;

import com.boshi.entity.GameHouse;
import com.boshi.entity.User;

public class BoshiServer
{

	private ServerSocket serverSocket;
	
	private static Map<String,Socket> userSocketMap = new HashMap<String,Socket>();
	private static Map<Integer,GameHouse> houseList = new HashMap<Integer,GameHouse>();
	private static Map<String,User> useInRoomHallListMap = new HashMap<String,User>();

	public BoshiServer( int port ) throws IOException
	{
		serverSocket = new ServerSocket( port );
	}

	public BoshiServer( String host, int port ) throws UnknownHostException,
			IOException
	{
		serverSocket = new ServerSocket( port, 0, InetAddress.getByName( host ) );
	}

	public static synchronized void userEnter(User user, Socket userSocket) 
	{
		userSocketMap.put(user.getUserID(), userSocket);
		useInRoomHallListMap.put(user.getUserID(), user);
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
	
	public static GameHouse getHouse( int houseID )
	{
		if( houseList.containsKey(Integer.valueOf(houseID)))
		{
			return houseList.get(Integer.valueOf(houseID));
		}
		else 
			return null;
	}
	
	public static synchronized void createHouse(GameHouse house) 
	{
		houseList.put(house.getHouseID(), house);
	}
	
	public static User[] getUsersInHouseHall()
	{
		return (User[])useInRoomHallListMap.values().toArray();
	}
	
	public static GameHouse[] getHouseList()
	{
		return (GameHouse[])houseList.values().toArray();
	}
	
	public static void InitSystemConfig()
	{
		for( int i=1;i<=20;i++)
		{
			GameHouse house = new GameHouse(i);
			houseList.put(Integer.valueOf(i), house);
		}
	}
	
	public static void main( String[] args ) throws IOException
	{
		InitSystemConfig();
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
