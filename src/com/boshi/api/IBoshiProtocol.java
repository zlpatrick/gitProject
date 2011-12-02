package com.boshi.api;

import java.net.Socket;

import com.boshi.packet.BoshiPacket;


public interface IBoshiProtocol
{
	public final int USERIDLENGTH = 16;
	void process(BoshiPacket packet, Socket userSocket) throws Exception;
	void setCommandID(short commandID);
	short getCommandID();
}
