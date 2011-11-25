package com.boshi.protocol;

import com.boshi.api.IBoshiProtocol;


public abstract class BoshiProtocol implements IBoshiProtocol
{
	private short commandID;
	
	public short getCommandID()
	{
		return this.commandID;
	}
	
	public void setCommandID(short commandID)
	{
		this.commandID = commandID;
	}
}
