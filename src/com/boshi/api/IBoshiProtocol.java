package com.boshi.api;

import com.boshi.packet.BoshiPacket;


public interface IBoshiProtocol
{
	void process(BoshiPacket packet);
}
