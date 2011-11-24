
package com.boshi.server;

import java.io.IOException;
import java.net.Socket;

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
				this.userSocket.getOutputStream( );
			}
			catch ( IOException e )
			{
				// TODO Auto-generated catch block
				e.printStackTrace( );
			}
		}

	}

}
