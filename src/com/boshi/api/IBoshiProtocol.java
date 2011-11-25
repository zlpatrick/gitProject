package com.boshi.api;

import java.net.Socket;

import com.boshi.packet.BoshiPacket;


public interface IBoshiProtocol
{
	void process(BoshiPacket packet, Socket userSocket);
}
