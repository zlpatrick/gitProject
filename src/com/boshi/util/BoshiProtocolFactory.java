package com.boshi.util;

import com.boshi.api.IBoshiProtocol;
import com.boshi.protocol.detail.EnterHouseListProtocol;


public class BoshiProtocolFactory
{
	public static IBoshiProtocol createProtocol(short commandID)
	{
		IBoshiProtocol protocol = null;
		if ( commandID ==1001)
			protocol = new EnterHouseListProtocol();
		protocol.setCommandID(commandID);
		return protocol;
	}
}
