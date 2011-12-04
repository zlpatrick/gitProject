package com.boshi.util;

import java.io.UnsupportedEncodingException;


public class DataTypeUtil
{
	public static String DEFAULTCHARSETNAME = "UTF-8";
	
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
	
	public static byte[] getFixedLengthStringBytes(String str,int length) throws UnsupportedEncodingException
	{
		byte[] result = new byte[length];
		byte[] temp = str.getBytes( DEFAULTCHARSETNAME );
		
		System.arraycopy( temp, 0, result, 0, temp.length-1 );
		return result;
	}
	
	public static byte[] getStringBytes(String str) throws UnsupportedEncodingException
	{
		return str.getBytes( DEFAULTCHARSETNAME );
	}
	
	public static String getStringFromBytes(byte[] bytes) throws UnsupportedEncodingException 
	{
		return new String( bytes, DEFAULTCHARSETNAME );
	}
}
