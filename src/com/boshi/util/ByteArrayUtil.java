package com.boshi.util;

public class ByteArrayUtil 
{
	public static byte[] getByteArrayInterval(byte[] src,int start,int end)
	{
		byte[] result = new byte[end - start + 1];
		System.arraycopy(src, start, result, 0, result.length);
		return result;
	}
}
