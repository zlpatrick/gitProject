package com.boshi.packet;


public class BoshiPacket
{
	public static final int HEAD_LENGTH = 10;
	
	private short commandID;
	private int length;
	private int resultID;
	private byte[] content;

	public short getCommandID( )
	{
		return this.commandID;
	}
	
	public int getLength()
	{
		return this.length;
	}
	
	public int getResultID()
	{
		return this.resultID;
	}
	
	public byte[] getContent()
	{
		return this.content;
	}
	
	public void setCommandID(short commandID)
	{
		this.commandID = commandID;
	}
	
	public void setLength(int length)
	{
		this.length = length;
	}
	
	public void setResultID(int resultID)
	{
		this.resultID = resultID;
	}
}
