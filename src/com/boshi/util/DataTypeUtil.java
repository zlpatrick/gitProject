package com.boshi.util;


public class DataTypeUtil
{

	public static int byteToInt( byte[] b )
	{
		int mask = 0xff;
		int temp = 0;
		int n = 0;
		for ( int i = 0; i < 4; i++ )
		{
			n <<= 8;
			temp = b[i] & mask;
			n |= temp;
		}
		return n;
	}

	public static byte[] intToByteArray(int i) 
	{
		byte[] result = new byte[4];
		result[0] = (byte) ((i >> 24) & 0xFF);
		result[1] = (byte) ((i >> 16) & 0xFF);
		result[2] = (byte) ((i >> 8) & 0xFF);
		result[3] = (byte) (i & 0xFF);
		return result;
	}
}
