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
	
	public static int byteToShort( byte[] b )
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

}
