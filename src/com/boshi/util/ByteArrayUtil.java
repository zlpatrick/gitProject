package com.boshi.util;

import java.util.List;

public class ByteArrayUtil 
{
	public static byte[] getByteArrayInterval(byte[] src,int start,int end)
	{
		byte[] result = new byte[end - start + 1];
		System.arraycopy(src, start, result, 0, result.length);
		return result;
	}
	
	public static byte[] getUnitedByteArrayFromList( List<byte[]> list )
	{
		byte[] result = list.get( 0 );
		for ( int i = 1; i < list.size( ); i++ )
		{
			result = concatBytes( result, list.get( i ) );
		}
		return result;
	}

	private static byte[] concatBytes( byte[] abyte1, byte[] abyte2 )
	{
		byte[] abyte = new byte[abyte1.length + abyte2.length];
		System.arraycopy( abyte1, 0, abyte, 0, abyte1.length );
		System.arraycopy( abyte2, 0, abyte, abyte1.length, abyte2.length );
		return abyte;
	}
}
